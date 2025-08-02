package com.tuv.tensiontracker.`data`.database

import kotlin.Long
import kotlin.String

public data class GetAllFeedbackWithSessions(
  public val id: Long,
  public val session_id: Long,
  public val control_rating: Long?,
  public val power_rating: Long?,
  public val durability_rating: Long?,
  public val spin_rating: Long?,
  public val feel_rating: Long?,
  public val comfort_rating: Long?,
  public val notes: String?,
  public val created_at: Long,
  public val updated_at: Long,
  public val date_strung: Long,
  public val main_string_id: Long,
  public val cross_string_id: Long?,
)
