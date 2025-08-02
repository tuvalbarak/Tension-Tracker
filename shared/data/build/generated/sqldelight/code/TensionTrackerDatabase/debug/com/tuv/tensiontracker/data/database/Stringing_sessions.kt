package com.tuv.tensiontracker.`data`.database

import kotlin.Double
import kotlin.Long
import kotlin.String

public data class Stringing_sessions(
  public val id: Long,
  public val date_strung: Long,
  public val main_string_id: Long,
  public val cross_string_id: Long?,
  public val main_tension_value: Double,
  public val main_tension_unit: String,
  public val cross_tension_value: Double?,
  public val cross_tension_unit: String?,
  public val price_paid: Double?,
  public val location_installed: String?,
  public val hours_until_break: Double?,
  public val hours_until_dead: Double?,
  public val created_at: Long,
  public val updated_at: Long,
)
