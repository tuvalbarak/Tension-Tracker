package com.tuv.tensiontracker.domain.model

data class StringRecommendation(
    val stringModel: StringModel,
    val recommendedTension: Tension,
    val matchScore: Double, // 0.0 to 1.0
    val reasons: List<RecommendationReason>
) {
    data class RecommendationReason(
        val category: String,
        val explanation: String,
        val impact: ReasonImpact
    )
    
    enum class ReasonImpact {
        HIGH, MEDIUM, LOW
    }
}