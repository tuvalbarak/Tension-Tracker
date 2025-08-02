package com.tuv.tensiontracker.domain.model

data class UserPreferences(
    val tensionUnit: TensionUnit = TensionUnit.KG,
    val ratingScale: RatingScale = RatingScale.FIVE_STAR,
    val defaultStringType: StringType? = null,
    val defaultTension: Double? = null,
    val autoBackup: Boolean = false
) {
    enum class RatingScale(val displayName: String, val maxValue: Int) {
        FIVE_STAR("5-Star Rating", 5),
        HUNDRED_POINT("100-Point Scale", 100)
    }
}