package com.tuv.tensiontracker.`data`.database

import kotlin.Long
import kotlin.String

public data class Stringing_locations(
  public val id: Long,
  public val location_name: String,
  public val usage_count: Long,
  public val last_used: Long,
  public val created_at: Long,
)
