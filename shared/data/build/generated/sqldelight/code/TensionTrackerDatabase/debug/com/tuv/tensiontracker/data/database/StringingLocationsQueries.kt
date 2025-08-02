package com.tuv.tensiontracker.`data`.database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class StringingLocationsQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> getAllLocations(mapper: (
    id: Long,
    location_name: String,
    usage_count: Long,
    last_used: Long,
    created_at: Long,
  ) -> T): Query<T> = Query(-1_302_715_493, arrayOf("stringing_locations"), driver,
      "StringingLocations.sq", "getAllLocations", """
  |SELECT stringing_locations.id, stringing_locations.location_name, stringing_locations.usage_count, stringing_locations.last_used, stringing_locations.created_at FROM stringing_locations 
  |ORDER BY usage_count DESC, last_used DESC
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3)!!,
      cursor.getLong(4)!!
    )
  }

  public fun getAllLocations(): Query<Stringing_locations> = getAllLocations { id, location_name,
      usage_count, last_used, created_at ->
    Stringing_locations(
      id,
      location_name,
      usage_count,
      last_used,
      created_at
    )
  }

  public fun <T : Any> searchLocations(`value`: String, mapper: (
    id: Long,
    location_name: String,
    usage_count: Long,
    last_used: Long,
    created_at: Long,
  ) -> T): Query<T> = SearchLocationsQuery(value) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3)!!,
      cursor.getLong(4)!!
    )
  }

  public fun searchLocations(value_: String): Query<Stringing_locations> = searchLocations(value_) {
      id, location_name, usage_count, last_used, created_at ->
    Stringing_locations(
      id,
      location_name,
      usage_count,
      last_used,
      created_at
    )
  }

  public fun <T : Any> getTopLocations(`value`: Long, mapper: (
    id: Long,
    location_name: String,
    usage_count: Long,
    last_used: Long,
    created_at: Long,
  ) -> T): Query<T> = GetTopLocationsQuery(value) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3)!!,
      cursor.getLong(4)!!
    )
  }

  public fun getTopLocations(value_: Long): Query<Stringing_locations> = getTopLocations(value_) {
      id, location_name, usage_count, last_used, created_at ->
    Stringing_locations(
      id,
      location_name,
      usage_count,
      last_used,
      created_at
    )
  }

  public fun insertOrIncrementLocation(
    location_name: String,
    last_used: Long,
    created_at: Long,
  ) {
    driver.execute(-1_812_848_240, """
        |INSERT INTO stringing_locations (location_name, usage_count, last_used, created_at)
        |VALUES (?, 1, ?, ?)
        |ON CONFLICT(location_name) DO UPDATE SET 
        |    usage_count = usage_count + 1,
        |    last_used = excluded.last_used
        """.trimMargin(), 3) {
          bindString(0, location_name)
          bindLong(1, last_used)
          bindLong(2, created_at)
        }
    notifyQueries(-1_812_848_240) { emit ->
      emit("stringing_locations")
    }
  }

  public fun deleteLocation(id: Long) {
    driver.execute(-1_490_029_800, """
        |DELETE FROM stringing_locations 
        |WHERE id = ?
        """.trimMargin(), 1) {
          bindLong(0, id)
        }
    notifyQueries(-1_490_029_800) { emit ->
      emit("stringing_locations")
    }
  }

  private inner class SearchLocationsQuery<out T : Any>(
    public val `value`: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("stringing_locations", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("stringing_locations", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-1_598_407_426, """
    |SELECT stringing_locations.id, stringing_locations.location_name, stringing_locations.usage_count, stringing_locations.last_used, stringing_locations.created_at FROM stringing_locations 
    |WHERE location_name LIKE '%' || ? || '%'
    |ORDER BY usage_count DESC, last_used DESC
    """.trimMargin(), mapper, 1) {
      bindString(0, value)
    }

    override fun toString(): String = "StringingLocations.sq:searchLocations"
  }

  private inner class GetTopLocationsQuery<out T : Any>(
    public val `value`: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("stringing_locations", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("stringing_locations", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-732_084_633, """
    |SELECT stringing_locations.id, stringing_locations.location_name, stringing_locations.usage_count, stringing_locations.last_used, stringing_locations.created_at FROM stringing_locations 
    |ORDER BY usage_count DESC, last_used DESC
    |LIMIT ?
    """.trimMargin(), mapper, 1) {
      bindLong(0, value)
    }

    override fun toString(): String = "StringingLocations.sq:getTopLocations"
  }
}
