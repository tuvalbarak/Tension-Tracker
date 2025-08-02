package com.tuv.tensiontracker.`data`.database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class UserPreferencesQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun getPreference(preference_key: String): Query<String> =
      GetPreferenceQuery(preference_key) { cursor ->
    cursor.getString(0)!!
  }

  public fun <T : Any> getAllPreferences(mapper: (
    id: Long,
    preference_key: String,
    preference_value: String,
    updated_at: Long,
  ) -> T): Query<T> = Query(1_151_336_975, arrayOf("user_preferences"), driver,
      "UserPreferences.sq", "getAllPreferences",
      "SELECT user_preferences.id, user_preferences.preference_key, user_preferences.preference_value, user_preferences.updated_at FROM user_preferences") {
      cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getLong(3)!!
    )
  }

  public fun getAllPreferences(): Query<User_preferences> = getAllPreferences { id, preference_key,
      preference_value, updated_at ->
    User_preferences(
      id,
      preference_key,
      preference_value,
      updated_at
    )
  }

  public fun insertOrUpdatePreference(
    preference_key: String,
    preference_value: String,
    updated_at: Long,
  ) {
    driver.execute(1_874_345_054, """
        |INSERT INTO user_preferences (preference_key, preference_value, updated_at)
        |VALUES (?, ?, ?)
        |ON CONFLICT(preference_key) DO UPDATE SET 
        |    preference_value = excluded.preference_value,
        |    updated_at = excluded.updated_at
        """.trimMargin(), 3) {
          bindString(0, preference_key)
          bindString(1, preference_value)
          bindLong(2, updated_at)
        }
    notifyQueries(1_874_345_054) { emit ->
      emit("user_preferences")
    }
  }

  public fun deletePreference(preference_key: String) {
    driver.execute(1_457_563_172, """
        |DELETE FROM user_preferences 
        |WHERE preference_key = ?
        """.trimMargin(), 1) {
          bindString(0, preference_key)
        }
    notifyQueries(1_457_563_172) { emit ->
      emit("user_preferences")
    }
  }

  private inner class GetPreferenceQuery<out T : Any>(
    public val preference_key: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("user_preferences", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("user_preferences", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(626_707_539, """
    |SELECT preference_value FROM user_preferences 
    |WHERE preference_key = ?
    """.trimMargin(), mapper, 1) {
      bindString(0, preference_key)
    }

    override fun toString(): String = "UserPreferences.sq:getPreference"
  }
}
