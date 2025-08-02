package com.tuv.tensiontracker.`data`.database

import app.cash.sqldelight.ExecutableQuery
import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Double
import kotlin.Long
import kotlin.String

public class StringingSessionsQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> getAllSessions(mapper: (
    id: Long,
    date_strung: Long,
    main_string_id: Long,
    cross_string_id: Long?,
    main_tension_value: Double,
    main_tension_unit: String,
    cross_tension_value: Double?,
    cross_tension_unit: String?,
    price_paid: Double?,
    location_installed: String?,
    hours_until_break: Double?,
    hours_until_dead: Double?,
    created_at: Long,
    updated_at: Long,
  ) -> T): Query<T> = Query(-349_570_649, arrayOf("stringing_sessions"), driver,
      "StringingSessions.sq", "getAllSessions", """
  |SELECT stringing_sessions.id, stringing_sessions.date_strung, stringing_sessions.main_string_id, stringing_sessions.cross_string_id, stringing_sessions.main_tension_value, stringing_sessions.main_tension_unit, stringing_sessions.cross_tension_value, stringing_sessions.cross_tension_unit, stringing_sessions.price_paid, stringing_sessions.location_installed, stringing_sessions.hours_until_break, stringing_sessions.hours_until_dead, stringing_sessions.created_at, stringing_sessions.updated_at FROM stringing_sessions 
  |ORDER BY date_strung DESC
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3),
      cursor.getDouble(4)!!,
      cursor.getString(5)!!,
      cursor.getDouble(6),
      cursor.getString(7),
      cursor.getDouble(8),
      cursor.getString(9),
      cursor.getDouble(10),
      cursor.getDouble(11),
      cursor.getLong(12)!!,
      cursor.getLong(13)!!
    )
  }

  public fun getAllSessions(): Query<Stringing_sessions> = getAllSessions { id, date_strung,
      main_string_id, cross_string_id, main_tension_value, main_tension_unit, cross_tension_value,
      cross_tension_unit, price_paid, location_installed, hours_until_break, hours_until_dead,
      created_at, updated_at ->
    Stringing_sessions(
      id,
      date_strung,
      main_string_id,
      cross_string_id,
      main_tension_value,
      main_tension_unit,
      cross_tension_value,
      cross_tension_unit,
      price_paid,
      location_installed,
      hours_until_break,
      hours_until_dead,
      created_at,
      updated_at
    )
  }

  public fun <T : Any> getSessionById(id: Long, mapper: (
    id: Long,
    date_strung: Long,
    main_string_id: Long,
    cross_string_id: Long?,
    main_tension_value: Double,
    main_tension_unit: String,
    cross_tension_value: Double?,
    cross_tension_unit: String?,
    price_paid: Double?,
    location_installed: String?,
    hours_until_break: Double?,
    hours_until_dead: Double?,
    created_at: Long,
    updated_at: Long,
  ) -> T): Query<T> = GetSessionByIdQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3),
      cursor.getDouble(4)!!,
      cursor.getString(5)!!,
      cursor.getDouble(6),
      cursor.getString(7),
      cursor.getDouble(8),
      cursor.getString(9),
      cursor.getDouble(10),
      cursor.getDouble(11),
      cursor.getLong(12)!!,
      cursor.getLong(13)!!
    )
  }

  public fun getSessionById(id: Long): Query<Stringing_sessions> = getSessionById(id) { id_,
      date_strung, main_string_id, cross_string_id, main_tension_value, main_tension_unit,
      cross_tension_value, cross_tension_unit, price_paid, location_installed, hours_until_break,
      hours_until_dead, created_at, updated_at ->
    Stringing_sessions(
      id_,
      date_strung,
      main_string_id,
      cross_string_id,
      main_tension_value,
      main_tension_unit,
      cross_tension_value,
      cross_tension_unit,
      price_paid,
      location_installed,
      hours_until_break,
      hours_until_dead,
      created_at,
      updated_at
    )
  }

  public fun <T : Any> getSessionsByString(
    main_string_id: Long,
    cross_string_id: Long?,
    mapper: (
      id: Long,
      date_strung: Long,
      main_string_id: Long,
      cross_string_id: Long?,
      main_tension_value: Double,
      main_tension_unit: String,
      cross_tension_value: Double?,
      cross_tension_unit: String?,
      price_paid: Double?,
      location_installed: String?,
      hours_until_break: Double?,
      hours_until_dead: Double?,
      created_at: Long,
      updated_at: Long,
    ) -> T,
  ): Query<T> = GetSessionsByStringQuery(main_string_id, cross_string_id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3),
      cursor.getDouble(4)!!,
      cursor.getString(5)!!,
      cursor.getDouble(6),
      cursor.getString(7),
      cursor.getDouble(8),
      cursor.getString(9),
      cursor.getDouble(10),
      cursor.getDouble(11),
      cursor.getLong(12)!!,
      cursor.getLong(13)!!
    )
  }

  public fun getSessionsByString(main_string_id: Long, cross_string_id: Long?):
      Query<Stringing_sessions> = getSessionsByString(main_string_id, cross_string_id) { id,
      date_strung, main_string_id_, cross_string_id_, main_tension_value, main_tension_unit,
      cross_tension_value, cross_tension_unit, price_paid, location_installed, hours_until_break,
      hours_until_dead, created_at, updated_at ->
    Stringing_sessions(
      id,
      date_strung,
      main_string_id_,
      cross_string_id_,
      main_tension_value,
      main_tension_unit,
      cross_tension_value,
      cross_tension_unit,
      price_paid,
      location_installed,
      hours_until_break,
      hours_until_dead,
      created_at,
      updated_at
    )
  }

  public fun <T : Any> getSessionsByLocation(location_installed: String?, mapper: (
    id: Long,
    date_strung: Long,
    main_string_id: Long,
    cross_string_id: Long?,
    main_tension_value: Double,
    main_tension_unit: String,
    cross_tension_value: Double?,
    cross_tension_unit: String?,
    price_paid: Double?,
    location_installed: String?,
    hours_until_break: Double?,
    hours_until_dead: Double?,
    created_at: Long,
    updated_at: Long,
  ) -> T): Query<T> = GetSessionsByLocationQuery(location_installed) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3),
      cursor.getDouble(4)!!,
      cursor.getString(5)!!,
      cursor.getDouble(6),
      cursor.getString(7),
      cursor.getDouble(8),
      cursor.getString(9),
      cursor.getDouble(10),
      cursor.getDouble(11),
      cursor.getLong(12)!!,
      cursor.getLong(13)!!
    )
  }

  public fun getSessionsByLocation(location_installed: String?): Query<Stringing_sessions> =
      getSessionsByLocation(location_installed) { id, date_strung, main_string_id, cross_string_id,
      main_tension_value, main_tension_unit, cross_tension_value, cross_tension_unit, price_paid,
      location_installed_, hours_until_break, hours_until_dead, created_at, updated_at ->
    Stringing_sessions(
      id,
      date_strung,
      main_string_id,
      cross_string_id,
      main_tension_value,
      main_tension_unit,
      cross_tension_value,
      cross_tension_unit,
      price_paid,
      location_installed_,
      hours_until_break,
      hours_until_dead,
      created_at,
      updated_at
    )
  }

  public fun getLastInsertedSessionId(): ExecutableQuery<Long> = Query(129_332_524, driver,
      "StringingSessions.sq", "getLastInsertedSessionId", "SELECT last_insert_rowid()") { cursor ->
    cursor.getLong(0)!!
  }

  public fun insertSession(
    date_strung: Long,
    main_string_id: Long,
    cross_string_id: Long?,
    main_tension_value: Double,
    main_tension_unit: String,
    cross_tension_value: Double?,
    cross_tension_unit: String?,
    price_paid: Double?,
    location_installed: String?,
    hours_until_break: Double?,
    hours_until_dead: Double?,
    created_at: Long,
    updated_at: Long,
  ) {
    driver.execute(-1_339_022_274, """
        |INSERT INTO stringing_sessions (
        |    date_strung, main_string_id, cross_string_id, main_tension_value, main_tension_unit,
        |    cross_tension_value, cross_tension_unit, price_paid, location_installed,
        |    hours_until_break, hours_until_dead, created_at, updated_at
        |) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.trimMargin(), 13) {
          bindLong(0, date_strung)
          bindLong(1, main_string_id)
          bindLong(2, cross_string_id)
          bindDouble(3, main_tension_value)
          bindString(4, main_tension_unit)
          bindDouble(5, cross_tension_value)
          bindString(6, cross_tension_unit)
          bindDouble(7, price_paid)
          bindString(8, location_installed)
          bindDouble(9, hours_until_break)
          bindDouble(10, hours_until_dead)
          bindLong(11, created_at)
          bindLong(12, updated_at)
        }
    notifyQueries(-1_339_022_274) { emit ->
      emit("stringing_sessions")
    }
  }

  public fun updateSession(
    date_strung: Long,
    main_string_id: Long,
    cross_string_id: Long?,
    main_tension_value: Double,
    main_tension_unit: String,
    cross_tension_value: Double?,
    cross_tension_unit: String?,
    price_paid: Double?,
    location_installed: String?,
    hours_until_break: Double?,
    hours_until_dead: Double?,
    updated_at: Long,
    id: Long,
  ) {
    driver.execute(1_971_502_126, """
        |UPDATE stringing_sessions 
        |SET date_strung = ?, main_string_id = ?, cross_string_id = ?, main_tension_value = ?,
        |    main_tension_unit = ?, cross_tension_value = ?, cross_tension_unit = ?, price_paid = ?,
        |    location_installed = ?, hours_until_break = ?, hours_until_dead = ?, updated_at = ?
        |WHERE id = ?
        """.trimMargin(), 13) {
          bindLong(0, date_strung)
          bindLong(1, main_string_id)
          bindLong(2, cross_string_id)
          bindDouble(3, main_tension_value)
          bindString(4, main_tension_unit)
          bindDouble(5, cross_tension_value)
          bindString(6, cross_tension_unit)
          bindDouble(7, price_paid)
          bindString(8, location_installed)
          bindDouble(9, hours_until_break)
          bindDouble(10, hours_until_dead)
          bindLong(11, updated_at)
          bindLong(12, id)
        }
    notifyQueries(1_971_502_126) { emit ->
      emit("stringing_sessions")
    }
  }

  public fun deleteSession(id: Long) {
    driver.execute(-1_032_286_964, """
        |DELETE FROM stringing_sessions 
        |WHERE id = ?
        """.trimMargin(), 1) {
          bindLong(0, id)
        }
    notifyQueries(-1_032_286_964) { emit ->
      emit("session_feedback")
      emit("stringing_sessions")
    }
  }

  private inner class GetSessionByIdQuery<out T : Any>(
    public val id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("stringing_sessions", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("stringing_sessions", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-1_951_493_167, """
    |SELECT stringing_sessions.id, stringing_sessions.date_strung, stringing_sessions.main_string_id, stringing_sessions.cross_string_id, stringing_sessions.main_tension_value, stringing_sessions.main_tension_unit, stringing_sessions.cross_tension_value, stringing_sessions.cross_tension_unit, stringing_sessions.price_paid, stringing_sessions.location_installed, stringing_sessions.hours_until_break, stringing_sessions.hours_until_dead, stringing_sessions.created_at, stringing_sessions.updated_at FROM stringing_sessions 
    |WHERE id = ?
    """.trimMargin(), mapper, 1) {
      bindLong(0, id)
    }

    override fun toString(): String = "StringingSessions.sq:getSessionById"
  }

  private inner class GetSessionsByStringQuery<out T : Any>(
    public val main_string_id: Long,
    public val cross_string_id: Long?,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("stringing_sessions", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("stringing_sessions", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(null, """
    |SELECT stringing_sessions.id, stringing_sessions.date_strung, stringing_sessions.main_string_id, stringing_sessions.cross_string_id, stringing_sessions.main_tension_value, stringing_sessions.main_tension_unit, stringing_sessions.cross_tension_value, stringing_sessions.cross_tension_unit, stringing_sessions.price_paid, stringing_sessions.location_installed, stringing_sessions.hours_until_break, stringing_sessions.hours_until_dead, stringing_sessions.created_at, stringing_sessions.updated_at FROM stringing_sessions 
    |WHERE main_string_id = ? OR cross_string_id ${ if (cross_string_id == null) "IS" else "=" } ?
    |ORDER BY date_strung DESC
    """.trimMargin(), mapper, 2) {
      bindLong(0, main_string_id)
      bindLong(1, cross_string_id)
    }

    override fun toString(): String = "StringingSessions.sq:getSessionsByString"
  }

  private inner class GetSessionsByLocationQuery<out T : Any>(
    public val location_installed: String?,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("stringing_sessions", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("stringing_sessions", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(null, """
    |SELECT stringing_sessions.id, stringing_sessions.date_strung, stringing_sessions.main_string_id, stringing_sessions.cross_string_id, stringing_sessions.main_tension_value, stringing_sessions.main_tension_unit, stringing_sessions.cross_tension_value, stringing_sessions.cross_tension_unit, stringing_sessions.price_paid, stringing_sessions.location_installed, stringing_sessions.hours_until_break, stringing_sessions.hours_until_dead, stringing_sessions.created_at, stringing_sessions.updated_at FROM stringing_sessions 
    |WHERE location_installed ${ if (location_installed == null) "IS" else "=" } ?
    |ORDER BY date_strung DESC
    """.trimMargin(), mapper, 1) {
      bindString(0, location_installed)
    }

    override fun toString(): String = "StringingSessions.sq:getSessionsByLocation"
  }
}
