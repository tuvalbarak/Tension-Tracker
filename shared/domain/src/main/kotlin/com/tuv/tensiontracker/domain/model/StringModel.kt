package com.tuv.tensiontracker.domain.model

data class StringModel(
    val id: Long,
    val name: String,
    val brand: String,
    val type: StringType,
    val gaugeMm: Double?,
    val construction: String?,
    val notes: String?,
    val priceMin: Double?,
    val priceMax: Double?,
    val isActive: Boolean = true
) {
    val displayName: String
        get() = "$brand $name"
        
    val priceRange: String?
        get() = when {
            priceMin != null && priceMax != null -> "$${"%.0f".format(priceMin)} - $${"%.0f".format(priceMax)}"
            priceMin != null -> "From $${"%.0f".format(priceMin)}"
            priceMax != null -> "Up to $${"%.0f".format(priceMax)}"
            else -> null
        }
}