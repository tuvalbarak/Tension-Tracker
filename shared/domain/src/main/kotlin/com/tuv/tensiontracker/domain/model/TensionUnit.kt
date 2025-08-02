package com.tuv.tensiontracker.domain.model

enum class TensionUnit(val displayName: String, val abbreviation: String) {
    KG("Kilograms", "kg"),
    LBS("Pounds", "lbs");
    
    companion object {
        fun fromAbbreviation(abbreviation: String): TensionUnit {
            return entries.find { it.abbreviation == abbreviation } 
                ?: throw IllegalArgumentException("Unknown tension unit: $abbreviation")
        }
        
        fun kgToLbs(kg: Double): Double = kg * 2.20462
        fun lbsToKg(lbs: Double): Double = lbs / 2.20462
    }
}