package com.tuv.tensiontracker.domain.model

enum class StringType(val displayName: String) {
    POLY("Polyester"),
    MULTI("Multifilament"),
    GUT("Natural Gut"),
    SYNTHETIC("Synthetic Gut"),
    HYBRID("Hybrid");
    
    companion object {
        fun fromDisplayName(displayName: String): StringType {
            return entries.find { it.displayName == displayName }
                ?: throw IllegalArgumentException("Unknown string type: $displayName")
        }
    }
}