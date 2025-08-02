package com.tuv.tensiontracker.`data`.database

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.tuv.tensiontracker.`data`.database.`data`.newInstance
import com.tuv.tensiontracker.`data`.database.`data`.schema
import kotlin.Unit

public interface TensionTrackerDatabase : Transacter {
  public val sessionFeedbackQueries: SessionFeedbackQueries

  public val stringCatalogQueries: StringCatalogQueries

  public val stringingLocationsQueries: StringingLocationsQueries

  public val stringingSessionsQueries: StringingSessionsQueries

  public val userPreferencesQueries: UserPreferencesQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = TensionTrackerDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): TensionTrackerDatabase =
        TensionTrackerDatabase::class.newInstance(driver)
  }
}
