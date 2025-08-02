package com.tuv.tensiontracker.`data`.database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class SessionFeedbackQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> getFeedbackBySessionId(session_id: Long, mapper: (
    id: Long,
    session_id: Long,
    control_rating: Long?,
    power_rating: Long?,
    durability_rating: Long?,
    spin_rating: Long?,
    feel_rating: Long?,
    comfort_rating: Long?,
    notes: String?,
    created_at: Long,
    updated_at: Long,
  ) -> T): Query<T> = GetFeedbackBySessionIdQuery(session_id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getLong(2),
      cursor.getLong(3),
      cursor.getLong(4),
      cursor.getLong(5),
      cursor.getLong(6),
      cursor.getLong(7),
      cursor.getString(8),
      cursor.getLong(9)!!,
      cursor.getLong(10)!!
    )
  }

  public fun getFeedbackBySessionId(session_id: Long): Query<Session_feedback> =
      getFeedbackBySessionId(session_id) { id, session_id_, control_rating, power_rating,
      durability_rating, spin_rating, feel_rating, comfort_rating, notes, created_at, updated_at ->
    Session_feedback(
      id,
      session_id_,
      control_rating,
      power_rating,
      durability_rating,
      spin_rating,
      feel_rating,
      comfort_rating,
      notes,
      created_at,
      updated_at
    )
  }

  public fun <T : Any> getAllFeedbackWithSessions(mapper: (
    id: Long,
    session_id: Long,
    control_rating: Long?,
    power_rating: Long?,
    durability_rating: Long?,
    spin_rating: Long?,
    feel_rating: Long?,
    comfort_rating: Long?,
    notes: String?,
    created_at: Long,
    updated_at: Long,
    date_strung: Long,
    main_string_id: Long,
    cross_string_id: Long?,
  ) -> T): Query<T> = Query(2_005_776_383, arrayOf("session_feedback", "stringing_sessions"),
      driver, "SessionFeedback.sq", "getAllFeedbackWithSessions", """
  |SELECT sf.id, sf.session_id, sf.control_rating, sf.power_rating, sf.durability_rating, sf.spin_rating, sf.feel_rating, sf.comfort_rating, sf.notes, sf.created_at, sf.updated_at, ss.date_strung, ss.main_string_id, ss.cross_string_id 
  |FROM session_feedback sf
  |JOIN stringing_sessions ss ON sf.session_id = ss.id
  |ORDER BY ss.date_strung DESC
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getLong(1)!!,
      cursor.getLong(2),
      cursor.getLong(3),
      cursor.getLong(4),
      cursor.getLong(5),
      cursor.getLong(6),
      cursor.getLong(7),
      cursor.getString(8),
      cursor.getLong(9)!!,
      cursor.getLong(10)!!,
      cursor.getLong(11)!!,
      cursor.getLong(12)!!,
      cursor.getLong(13)
    )
  }

  public fun getAllFeedbackWithSessions(): Query<GetAllFeedbackWithSessions> =
      getAllFeedbackWithSessions { id, session_id, control_rating, power_rating, durability_rating,
      spin_rating, feel_rating, comfort_rating, notes, created_at, updated_at, date_strung,
      main_string_id, cross_string_id ->
    GetAllFeedbackWithSessions(
      id,
      session_id,
      control_rating,
      power_rating,
      durability_rating,
      spin_rating,
      feel_rating,
      comfort_rating,
      notes,
      created_at,
      updated_at,
      date_strung,
      main_string_id,
      cross_string_id
    )
  }

  public fun insertFeedback(
    session_id: Long,
    control_rating: Long?,
    power_rating: Long?,
    durability_rating: Long?,
    spin_rating: Long?,
    feel_rating: Long?,
    comfort_rating: Long?,
    notes: String?,
    created_at: Long,
    updated_at: Long,
  ) {
    driver.execute(1_959_508_138, """
        |INSERT INTO session_feedback (
        |    session_id, control_rating, power_rating, durability_rating, spin_rating,
        |    feel_rating, comfort_rating, notes, created_at, updated_at
        |) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.trimMargin(), 10) {
          bindLong(0, session_id)
          bindLong(1, control_rating)
          bindLong(2, power_rating)
          bindLong(3, durability_rating)
          bindLong(4, spin_rating)
          bindLong(5, feel_rating)
          bindLong(6, comfort_rating)
          bindString(7, notes)
          bindLong(8, created_at)
          bindLong(9, updated_at)
        }
    notifyQueries(1_959_508_138) { emit ->
      emit("session_feedback")
    }
  }

  public fun updateFeedback(
    control_rating: Long?,
    power_rating: Long?,
    durability_rating: Long?,
    spin_rating: Long?,
    feel_rating: Long?,
    comfort_rating: Long?,
    notes: String?,
    updated_at: Long,
    session_id: Long,
  ) {
    driver.execute(1_506_549_434, """
        |UPDATE session_feedback 
        |SET control_rating = ?, power_rating = ?, durability_rating = ?, spin_rating = ?,
        |    feel_rating = ?, comfort_rating = ?, notes = ?, updated_at = ?
        |WHERE session_id = ?
        """.trimMargin(), 9) {
          bindLong(0, control_rating)
          bindLong(1, power_rating)
          bindLong(2, durability_rating)
          bindLong(3, spin_rating)
          bindLong(4, feel_rating)
          bindLong(5, comfort_rating)
          bindString(6, notes)
          bindLong(7, updated_at)
          bindLong(8, session_id)
        }
    notifyQueries(1_506_549_434) { emit ->
      emit("session_feedback")
    }
  }

  public fun deleteFeedbackBySessionId(session_id: Long) {
    driver.execute(2_094_901_374, """
        |DELETE FROM session_feedback 
        |WHERE session_id = ?
        """.trimMargin(), 1) {
          bindLong(0, session_id)
        }
    notifyQueries(2_094_901_374) { emit ->
      emit("session_feedback")
    }
  }

  private inner class GetFeedbackBySessionIdQuery<out T : Any>(
    public val session_id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("session_feedback", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("session_feedback", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-1_246_278_901, """
    |SELECT session_feedback.id, session_feedback.session_id, session_feedback.control_rating, session_feedback.power_rating, session_feedback.durability_rating, session_feedback.spin_rating, session_feedback.feel_rating, session_feedback.comfort_rating, session_feedback.notes, session_feedback.created_at, session_feedback.updated_at FROM session_feedback 
    |WHERE session_id = ?
    """.trimMargin(), mapper, 1) {
      bindLong(0, session_id)
    }

    override fun toString(): String = "SessionFeedback.sq:getFeedbackBySessionId"
  }
}
