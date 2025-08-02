package com.tuv.tensiontracker.ui.utils

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import java.text.DateFormat
import java.util.Date
import java.util.Locale

object DateFormatter {
    
    /**
     * Formats a date according to the device's locale.
     * Returns either MM/dd/yyyy (US) or dd/MM/yyyy (most other countries)
     */
    fun formatDate(instant: Instant): String {
        val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        
        // Convert to Java Date for locale-aware formatting
        val javaDate = Date(instant.toEpochMilliseconds())
        
        // Use system locale to determine format
        val locale = Locale.getDefault()
        val dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale)
        
        return dateFormat.format(javaDate)
    }
    
    /**
     * Formats a date in short format according to the device's locale.
     * Returns either MM/dd (US) or dd/MM (most other countries)
     */
    fun formatDateShort(instant: Instant): String {
        val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        
        // Use locale to determine day/month order
        val locale = Locale.getDefault()
        
        return if (isUSLocale(locale)) {
            // US format: MM/dd
            "${localDateTime.monthNumber}/${localDateTime.dayOfMonth}"
        } else {
            // Most other countries: dd/MM
            "${localDateTime.dayOfMonth}/${localDateTime.monthNumber}"
        }
    }
    
    /**
     * Formats a date with year in locale-appropriate format.
     * Returns either MM/dd/yyyy (US) or dd/MM/yyyy (most other countries)
     */
    fun formatDateWithYear(instant: Instant): String {
        val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        
        // Use locale to determine day/month order
        val locale = Locale.getDefault()
        
        return if (isUSLocale(locale)) {
            // US format: MM/dd/yyyy
            "${localDateTime.monthNumber}/${localDateTime.dayOfMonth}/${localDateTime.year}"
        } else {
            // Most other countries: dd/MM/yyyy
            "${localDateTime.dayOfMonth}/${localDateTime.monthNumber}/${localDateTime.year}"
        }
    }
    
    /**
     * Returns a relative date string like "Today", "Yesterday", or formatted date
     */
    fun formatRelativeDate(instant: Instant): String {
        val now = kotlinx.datetime.Clock.System.now()
        val daysBetween = (now - instant).inWholeDays
        
        return when (daysBetween) {
            0L -> "Today"
            1L -> "Yesterday" 
            in 2..6 -> "$daysBetween days ago"
            else -> formatDateShort(instant)
        }
    }
    
    private fun isUSLocale(locale: Locale): Boolean {
        return locale.country.equals("US", ignoreCase = true) ||
               locale.language.equals("en", ignoreCase = true) && locale.country.equals("US", ignoreCase = true)
    }
}