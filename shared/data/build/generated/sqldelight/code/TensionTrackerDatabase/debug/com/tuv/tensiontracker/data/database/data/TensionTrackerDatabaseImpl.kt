package com.tuv.tensiontracker.`data`.database.`data`

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.tuv.tensiontracker.`data`.database.SessionFeedbackQueries
import com.tuv.tensiontracker.`data`.database.StringCatalogQueries
import com.tuv.tensiontracker.`data`.database.StringingLocationsQueries
import com.tuv.tensiontracker.`data`.database.StringingSessionsQueries
import com.tuv.tensiontracker.`data`.database.TensionTrackerDatabase
import com.tuv.tensiontracker.`data`.database.UserPreferencesQueries
import kotlin.Long
import kotlin.Unit
import kotlin.reflect.KClass

internal val KClass<TensionTrackerDatabase>.schema: SqlSchema<QueryResult.Value<Unit>>
  get() = TensionTrackerDatabaseImpl.Schema

internal fun KClass<TensionTrackerDatabase>.newInstance(driver: SqlDriver): TensionTrackerDatabase =
    TensionTrackerDatabaseImpl(driver)

private class TensionTrackerDatabaseImpl(
  driver: SqlDriver,
) : TransacterImpl(driver), TensionTrackerDatabase {
  override val sessionFeedbackQueries: SessionFeedbackQueries = SessionFeedbackQueries(driver)

  override val stringCatalogQueries: StringCatalogQueries = StringCatalogQueries(driver)

  override val stringingLocationsQueries: StringingLocationsQueries =
      StringingLocationsQueries(driver)

  override val stringingSessionsQueries: StringingSessionsQueries = StringingSessionsQueries(driver)

  override val userPreferencesQueries: UserPreferencesQueries = UserPreferencesQueries(driver)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE session_feedback (
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    session_id INTEGER NOT NULL,
          |    control_rating INTEGER, -- 1-5 stars or 0-100
          |    power_rating INTEGER,
          |    durability_rating INTEGER, 
          |    spin_rating INTEGER,
          |    feel_rating INTEGER,
          |    comfort_rating INTEGER,
          |    notes TEXT,
          |    created_at INTEGER NOT NULL,
          |    updated_at INTEGER NOT NULL,
          |    FOREIGN KEY (session_id) REFERENCES stringing_sessions(id) ON DELETE CASCADE
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE string_catalog (
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    name TEXT NOT NULL,
          |    brand TEXT NOT NULL,
          |    type TEXT NOT NULL, -- "Poly", "Multi", "Gut", "Synthetic", "Hybrid"
          |    gauge_mm REAL, -- String gauge in millimeters
          |    construction TEXT, -- "Monofilament", "Multifilament", etc.
          |    notes TEXT,
          |    price_min REAL,
          |    price_max REAL,
          |    is_active INTEGER NOT NULL DEFAULT 1 -- 1 for active, 0 for discontinued
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE stringing_locations (
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    location_name TEXT NOT NULL UNIQUE,
          |    usage_count INTEGER NOT NULL DEFAULT 1,
          |    last_used INTEGER NOT NULL, -- Unix timestamp
          |    created_at INTEGER NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE stringing_sessions (
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    date_strung INTEGER NOT NULL, -- Unix timestamp
          |    main_string_id INTEGER NOT NULL,
          |    cross_string_id INTEGER, -- Optional for hybrid setups
          |    main_tension_value REAL NOT NULL,
          |    main_tension_unit TEXT NOT NULL, -- "kg" or "lbs"
          |    cross_tension_value REAL,
          |    cross_tension_unit TEXT,
          |    price_paid REAL,
          |    location_installed TEXT,
          |    hours_until_break REAL,
          |    hours_until_dead REAL,
          |    created_at INTEGER NOT NULL, -- Unix timestamp
          |    updated_at INTEGER NOT NULL  -- Unix timestamp
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE user_preferences (
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    preference_key TEXT NOT NULL UNIQUE,
          |    preference_value TEXT NOT NULL,
          |    updated_at INTEGER NOT NULL
          |)
          """.trimMargin(), 0)
      return QueryResult.Unit
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Long,
      newVersion: Long,
      vararg callbacks: AfterVersion,
    ): QueryResult.Value<Unit> = QueryResult.Unit
  }
}
