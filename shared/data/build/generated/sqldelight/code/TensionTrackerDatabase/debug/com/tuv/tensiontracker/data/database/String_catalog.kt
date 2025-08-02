package com.tuv.tensiontracker.`data`.database

import kotlin.Double
import kotlin.Long
import kotlin.String

public data class String_catalog(
  public val id: Long,
  public val name: String,
  public val brand: String,
  public val type: String,
  public val gauge_mm: Double?,
  public val construction: String?,
  public val notes: String?,
  public val price_min: Double?,
  public val price_max: Double?,
  public val is_active: Long,
)
