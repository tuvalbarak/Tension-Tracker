package com.tuv.tensiontracker.domain.usecase.recommendations

import com.tuv.tensiontracker.domain.model.PlayerProfile
import com.tuv.tensiontracker.domain.model.StringRecommendation
import com.tuv.tensiontracker.domain.model.StringModel
import com.tuv.tensiontracker.domain.model.StringType
import com.tuv.tensiontracker.domain.model.Tension
import com.tuv.tensiontracker.domain.model.TensionUnit
import com.tuv.tensiontracker.domain.repository.StringCatalogRepository
import kotlinx.coroutines.flow.first

class GetStringRecommendationsUseCase(
    private val stringCatalogRepository: StringCatalogRepository
) {
    
    suspend operator fun invoke(playerProfile: PlayerProfile): List<StringRecommendation> {
        // Get the first emission from the Flow
        val stringsList = stringCatalogRepository.getAllActiveStrings().first()
        
        return stringsList
            .map { string -> 
                val score = calculateMatchScore(string, playerProfile)
                val reasons = generateReasons(string, playerProfile)
                val recommendedTension = calculateRecommendedTension(string, playerProfile)
                
                StringRecommendation(
                    stringModel = string,
                    recommendedTension = recommendedTension,
                    matchScore = score,
                    reasons = reasons
                )
            }
            .filter { it.matchScore > 0.3 } // Only recommend strings with decent match
            .sortedByDescending { it.matchScore }
            .take(3)
    }
    
    private fun calculateMatchScore(string: StringModel, profile: PlayerProfile): Double {
        var score = 0.0
        var totalWeight = 0.0
        
        // String type preferences based on player profile
        val typeScore = when (string.type) {
            StringType.POLY -> when {
                profile.skillLevel in listOf(PlayerProfile.SkillLevel.ADVANCED, PlayerProfile.SkillLevel.PROFESSIONAL) -> 0.9
                profile.playingStyle == PlayerProfile.PlayingStyle.AGGRESSIVE_BASELINER -> 0.8
                profile.injuryConcerns.contains(PlayerProfile.InjuryConcern.TENNIS_ELBOW) -> 0.3
                else -> 0.6
            }
            StringType.MULTI -> when {
                profile.injuryConcerns.isNotEmpty() && profile.injuryConcerns != listOf(PlayerProfile.InjuryConcern.NONE) -> 0.9
                profile.skillLevel in listOf(PlayerProfile.SkillLevel.BEGINNER, PlayerProfile.SkillLevel.RECREATIONAL) -> 0.8
                else -> 0.7
            }
            StringType.GUT -> when {
                profile.budgetSensitivity == PlayerProfile.BudgetSensitivity.PREMIUM_ONLY -> 0.9
                profile.skillLevel in listOf(PlayerProfile.SkillLevel.ADVANCED, PlayerProfile.SkillLevel.PROFESSIONAL) -> 0.8
                profile.budgetSensitivity == PlayerProfile.BudgetSensitivity.BUDGET_CONSCIOUS -> 0.2
                else -> 0.5
            }
            StringType.SYNTHETIC -> when {
                profile.budgetSensitivity == PlayerProfile.BudgetSensitivity.BUDGET_CONSCIOUS -> 0.8
                profile.skillLevel in listOf(PlayerProfile.SkillLevel.BEGINNER, PlayerProfile.SkillLevel.RECREATIONAL) -> 0.7
                else -> 0.4
            }
            StringType.HYBRID -> when {
                profile.skillLevel in listOf(PlayerProfile.SkillLevel.ADVANCED, PlayerProfile.SkillLevel.PROFESSIONAL) -> 0.7
                else -> 0.3
            }
        }
        
        score += typeScore * 0.4
        totalWeight += 0.4
        
        // Budget considerations
        val budgetScore = when (profile.budgetSensitivity) {
            PlayerProfile.BudgetSensitivity.BUDGET_CONSCIOUS -> when {
                (string.priceMax ?: 20.0) <= 15.0 -> 1.0
                (string.priceMax ?: 20.0) <= 25.0 -> 0.6
                else -> 0.2
            }
            PlayerProfile.BudgetSensitivity.MODERATE -> when {
                (string.priceMax ?: 20.0) <= 30.0 -> 1.0
                else -> 0.7
            }
            PlayerProfile.BudgetSensitivity.PREMIUM_ONLY -> when {
                (string.priceMin ?: 0.0) >= 25.0 -> 1.0
                else -> 0.5
            }
        }
        
        score += budgetScore * 0.3
        totalWeight += 0.3
        
        // String characteristics match
        val characteristicsScore = profile.desiredCharacteristics.entries.sumOf { (characteristic, importance) ->
            val stringScore = getStringCharacteristicScore(string, characteristic)
            stringScore * importance / 5.0
        } / profile.desiredCharacteristics.size
        
        score += characteristicsScore * 0.3
        totalWeight += 0.3
        
        return if (totalWeight > 0) score / totalWeight else 0.0
    }
    
    private fun getStringCharacteristicScore(string: StringModel, characteristic: PlayerProfile.StringCharacteristic): Double {
        return when (characteristic) {
            PlayerProfile.StringCharacteristic.CONTROL -> when (string.type) {
                StringType.POLY -> 0.9
                StringType.GUT -> 0.7
                StringType.MULTI -> 0.6
                StringType.SYNTHETIC -> 0.5
                StringType.HYBRID -> 0.8
            }
            PlayerProfile.StringCharacteristic.POWER -> when (string.type) {
                StringType.GUT -> 0.9
                StringType.MULTI -> 0.8
                StringType.SYNTHETIC -> 0.7
                StringType.POLY -> 0.4
                StringType.HYBRID -> 0.7
            }
            PlayerProfile.StringCharacteristic.SPIN -> when (string.type) {
                StringType.POLY -> 0.9
                StringType.HYBRID -> 0.7
                StringType.GUT -> 0.6
                StringType.MULTI -> 0.5
                StringType.SYNTHETIC -> 0.4
            }
            PlayerProfile.StringCharacteristic.COMFORT -> when (string.type) {
                StringType.GUT -> 0.9
                StringType.MULTI -> 0.8
                StringType.SYNTHETIC -> 0.6
                StringType.POLY -> 0.3
                StringType.HYBRID -> 0.6
            }
            PlayerProfile.StringCharacteristic.DURABILITY -> when (string.type) {
                StringType.POLY -> 0.9
                StringType.SYNTHETIC -> 0.7
                StringType.HYBRID -> 0.6
                StringType.MULTI -> 0.4
                StringType.GUT -> 0.3
            }
            PlayerProfile.StringCharacteristic.FEEL -> when (string.type) {
                StringType.GUT -> 0.9
                StringType.MULTI -> 0.8
                StringType.HYBRID -> 0.7
                StringType.POLY -> 0.5
                StringType.SYNTHETIC -> 0.4
            }
        }
    }
    
    private fun generateReasons(string: StringModel, profile: PlayerProfile): List<StringRecommendation.RecommendationReason> {
        val reasons = mutableListOf<StringRecommendation.RecommendationReason>()
        
        // Type-based reasons
        when (string.type) {
            StringType.POLY -> {
                if (profile.desiredCharacteristics[PlayerProfile.StringCharacteristic.CONTROL] ?: 0 >= 4) {
                    reasons.add(
                        StringRecommendation.RecommendationReason(
                            "Control",
                            "Polyester strings excel at providing precise control",
                            StringRecommendation.ReasonImpact.HIGH
                        )
                    )
                }
                if (profile.desiredCharacteristics[PlayerProfile.StringCharacteristic.SPIN] ?: 0 >= 4) {
                    reasons.add(
                        StringRecommendation.RecommendationReason(
                            "Spin",
                            "Textured poly surface helps generate topspin",
                            StringRecommendation.ReasonImpact.HIGH
                        )
                    )
                }
                if (profile.desiredCharacteristics[PlayerProfile.StringCharacteristic.DURABILITY] ?: 0 >= 4) {
                    reasons.add(
                        StringRecommendation.RecommendationReason(
                            "Durability",
                            "Polyester strings last longer than most alternatives",
                            StringRecommendation.ReasonImpact.MEDIUM
                        )
                    )
                }
            }
            StringType.MULTI -> {
                if (profile.injuryConcerns.isNotEmpty() && profile.injuryConcerns != listOf(PlayerProfile.InjuryConcern.NONE)) {
                    reasons.add(
                        StringRecommendation.RecommendationReason(
                            "Comfort",
                            "Multifilament strings reduce arm shock and vibration",
                            StringRecommendation.ReasonImpact.HIGH
                        )
                    )
                }
                if (profile.desiredCharacteristics[PlayerProfile.StringCharacteristic.FEEL] ?: 0 >= 4) {
                    reasons.add(
                        StringRecommendation.RecommendationReason(
                            "Feel",
                            "Multifilament provides excellent touch and feel",
                            StringRecommendation.ReasonImpact.HIGH
                        )
                    )
                }
            }
            StringType.GUT -> {
                if (profile.budgetSensitivity == PlayerProfile.BudgetSensitivity.PREMIUM_ONLY) {
                    reasons.add(
                        StringRecommendation.RecommendationReason(
                            "Premium Quality",
                            "Natural gut offers the best feel and power available",
                            StringRecommendation.ReasonImpact.HIGH
                        )
                    )
                }
            }
            StringType.SYNTHETIC -> {
                if (profile.budgetSensitivity == PlayerProfile.BudgetSensitivity.BUDGET_CONSCIOUS) {
                    reasons.add(
                        StringRecommendation.RecommendationReason(
                            "Value",
                            "Synthetic gut provides good performance at an affordable price",
                            StringRecommendation.ReasonImpact.MEDIUM
                        )
                    )
                }
            }
            StringType.HYBRID -> {
                reasons.add(
                    StringRecommendation.RecommendationReason(
                        "Versatility",
                        "Hybrid setup combines benefits of different string types",
                        StringRecommendation.ReasonImpact.MEDIUM
                    )
                )
            }
        }
        
        return reasons
    }
    
    private fun calculateRecommendedTension(string: StringModel, profile: PlayerProfile): Tension {
        // Base tension recommendations in kg
        val baseTension = when (string.type) {
            StringType.POLY -> 23.0
            StringType.MULTI -> 25.0
            StringType.GUT -> 24.0
            StringType.SYNTHETIC -> 26.0
            StringType.HYBRID -> 24.0
        }
        
        // Adjust based on player characteristics
        var adjustedTension = baseTension
        
        // Skill level adjustments
        when (profile.skillLevel) {
            PlayerProfile.SkillLevel.BEGINNER, PlayerProfile.SkillLevel.RECREATIONAL -> adjustedTension += 2.0
            PlayerProfile.SkillLevel.ADVANCED, PlayerProfile.SkillLevel.PROFESSIONAL -> adjustedTension -= 1.0
            else -> {} // No adjustment for intermediate
        }
        
        // Playing style adjustments
        when (profile.playingStyle) {
            PlayerProfile.PlayingStyle.AGGRESSIVE_BASELINER -> adjustedTension -= 1.0
            PlayerProfile.PlayingStyle.DEFENSIVE_BASELINER -> adjustedTension += 1.0
            PlayerProfile.PlayingStyle.SERVE_AND_VOLLEY -> adjustedTension += 0.5
            else -> {} // No adjustment for others
        }
        
        // Injury concerns - lower tension for comfort
        if (profile.injuryConcerns.isNotEmpty() && profile.injuryConcerns != listOf(PlayerProfile.InjuryConcern.NONE)) {
            adjustedTension -= 2.0
        }
        
        // Ensure tension is within reasonable range
        adjustedTension = adjustedTension.coerceIn(18.0, 30.0)
        
        return Tension(adjustedTension, TensionUnit.KG)
    }
}