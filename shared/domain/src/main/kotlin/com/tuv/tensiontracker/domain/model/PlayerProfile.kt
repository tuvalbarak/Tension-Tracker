package com.tuv.tensiontracker.domain.model

data class PlayerProfile(
    val skillLevel: SkillLevel,
    val playingStyle: PlayingStyle,
    val injuryConcerns: List<InjuryConcern>,
    val budgetSensitivity: BudgetSensitivity,
    val desiredCharacteristics: Map<StringCharacteristic, Int> // 1-5 importance rating
) {
    enum class SkillLevel(val displayName: String) {
        BEGINNER("Beginner"),
        RECREATIONAL("Recreational"),
        INTERMEDIATE("Intermediate"),
        ADVANCED("Advanced"),
        PROFESSIONAL("Professional")
    }
    
    enum class PlayingStyle(val displayName: String) {
        AGGRESSIVE_BASELINER("Aggressive Baseliner"),
        DEFENSIVE_BASELINER("Defensive Baseliner"),
        ALL_COURT("All-Court Player"),
        SERVE_AND_VOLLEY("Serve and Volley"),
        NET_PLAYER("Net Player")
    }
    
    enum class InjuryConcern(val displayName: String) {
        TENNIS_ELBOW("Tennis Elbow"),
        WRIST_ISSUES("Wrist Issues"),
        SHOULDER_PROBLEMS("Shoulder Problems"),
        ARM_FATIGUE("Arm Fatigue"),
        NONE("No Concerns")
    }
    
    enum class BudgetSensitivity(val displayName: String) {
        BUDGET_CONSCIOUS("Budget Conscious"),
        MODERATE("Moderate"),
        PREMIUM_ONLY("Premium Only")
    }
    
    enum class StringCharacteristic(val displayName: String) {
        CONTROL("Control"),
        POWER("Power"),
        SPIN("Spin"),
        COMFORT("Comfort"),
        DURABILITY("Durability"),
        FEEL("Feel")
    }
}