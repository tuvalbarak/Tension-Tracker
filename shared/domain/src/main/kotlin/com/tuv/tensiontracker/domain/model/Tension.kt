package com.tuv.tensiontracker.domain.model

data class Tension(
    val value: Double,
    val unit: TensionUnit
) {
    fun convertTo(targetUnit: TensionUnit): Tension {
        if (unit == targetUnit) return this
        
        val convertedValue = when {
            unit == TensionUnit.KG && targetUnit == TensionUnit.LBS -> TensionUnit.kgToLbs(value)
            unit == TensionUnit.LBS && targetUnit == TensionUnit.KG -> TensionUnit.lbsToKg(value)
            else -> value
        }
        
        return Tension(convertedValue, targetUnit)
    }
    
    override fun toString(): String = "${"%.1f".format(value)} ${unit.abbreviation}"
}