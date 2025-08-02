package com.tuv.tensiontracker.`data`.database

import kotlin.Long
import kotlin.String

public data class User_preferences(
  public val id: Long,
  public val preference_key: String,
  public val preference_value: String,
  public val updated_at: Long,
)
