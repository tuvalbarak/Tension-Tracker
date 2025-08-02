package com.tuv.tensiontracker.domain.model

enum class StringType(val displayName: String) {
    POLY("Polyester"),
    MULTI("Multifilament"),
    GUT("Natural Gut"),
    SYNTHETIC("Synthetic Gut"),
    HYBRID("Hybrid");
    
    companion object {
        fun fromDisplayName(displayName: String): StringType {
            // First try exact match with full display names
            entries.find { it.displayName == displayName }?.let { return it }
            
            // Then try matching with short names (for JSON compatibility)
            return when (displayName.uppercase()) {
                "POLY", "POLYESTER" -> POLY
                "MULTI", "MULTIFILAMENT" -> MULTI
                "GUT", "NATURAL GUT", "NATURAL_GUT" -> GUT
                "SYNTHETIC", "SYNTHETIC GUT", "SYNTHETIC_GUT" -> SYNTHETIC
                "HYBRID" -> HYBRID
                else -> throw IllegalArgumentException("Unknown string type: $displayName")
            }
        }
    }
}