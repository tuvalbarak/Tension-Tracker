package com.tuv.tensiontracker.data.database

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.tuv.tensiontracker.data.database.adapters.InstantAdapter
import com.tuv.tensiontracker.data.database.adapters.StringTypeAdapter
import com.tuv.tensiontracker.data.database.adapters.TensionUnitAdapter

class DatabaseFactory(private val context: Context) {
    
    fun createDatabase(): TensionTrackerDatabase {
        val driver = AndroidSqliteDriver(TensionTrackerDatabase.Schema, context, "tension_tracker.db")
        
        return TensionTrackerDatabase(
            driver = driver
        )
    }
}