package com.tuv.tensiontracker.`data`.database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Double
import kotlin.Long
import kotlin.String

public class StringCatalogQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> getAllActiveStrings(mapper: (
    id: Long,
    name: String,
    brand: String,
    type: String,
    gauge_mm: Double?,
    construction: String?,
    notes: String?,
    price_min: Double?,
    price_max: Double?,
    is_active: Long,
  ) -> T): Query<T> = Query(1_892_604_472, arrayOf("string_catalog"), driver, "StringCatalog.sq",
      "getAllActiveStrings", """
  |SELECT string_catalog.id, string_catalog.name, string_catalog.brand, string_catalog.type, string_catalog.gauge_mm, string_catalog.construction, string_catalog.notes, string_catalog.price_min, string_catalog.price_max, string_catalog.is_active FROM string_catalog 
  |WHERE is_active = 1
  |ORDER BY brand, name
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getDouble(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getDouble(7),
      cursor.getDouble(8),
      cursor.getLong(9)!!
    )
  }

  public fun getAllActiveStrings(): Query<String_catalog> = getAllActiveStrings { id, name, brand,
      type, gauge_mm, construction, notes, price_min, price_max, is_active ->
    String_catalog(
      id,
      name,
      brand,
      type,
      gauge_mm,
      construction,
      notes,
      price_min,
      price_max,
      is_active
    )
  }

  public fun <T : Any> getStringsByBrand(brand: String, mapper: (
    id: Long,
    name: String,
    brand: String,
    type: String,
    gauge_mm: Double?,
    construction: String?,
    notes: String?,
    price_min: Double?,
    price_max: Double?,
    is_active: Long,
  ) -> T): Query<T> = GetStringsByBrandQuery(brand) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getDouble(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getDouble(7),
      cursor.getDouble(8),
      cursor.getLong(9)!!
    )
  }

  public fun getStringsByBrand(brand: String): Query<String_catalog> = getStringsByBrand(brand) {
      id, name, brand_, type, gauge_mm, construction, notes, price_min, price_max, is_active ->
    String_catalog(
      id,
      name,
      brand_,
      type,
      gauge_mm,
      construction,
      notes,
      price_min,
      price_max,
      is_active
    )
  }

  public fun <T : Any> getStringsByType(type: String, mapper: (
    id: Long,
    name: String,
    brand: String,
    type: String,
    gauge_mm: Double?,
    construction: String?,
    notes: String?,
    price_min: Double?,
    price_max: Double?,
    is_active: Long,
  ) -> T): Query<T> = GetStringsByTypeQuery(type) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getDouble(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getDouble(7),
      cursor.getDouble(8),
      cursor.getLong(9)!!
    )
  }

  public fun getStringsByType(type: String): Query<String_catalog> = getStringsByType(type) { id,
      name, brand, type_, gauge_mm, construction, notes, price_min, price_max, is_active ->
    String_catalog(
      id,
      name,
      brand,
      type_,
      gauge_mm,
      construction,
      notes,
      price_min,
      price_max,
      is_active
    )
  }

  public fun <T : Any> searchStrings(
    `value`: String,
    value_: String,
    mapper: (
      id: Long,
      name: String,
      brand: String,
      type: String,
      gauge_mm: Double?,
      construction: String?,
      notes: String?,
      price_min: Double?,
      price_max: Double?,
      is_active: Long,
    ) -> T,
  ): Query<T> = SearchStringsQuery(value, value_) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getDouble(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getDouble(7),
      cursor.getDouble(8),
      cursor.getLong(9)!!
    )
  }

  public fun searchStrings(value_: String, value__: String): Query<String_catalog> =
      searchStrings(value_, value__) { id, name, brand, type, gauge_mm, construction, notes,
      price_min, price_max, is_active ->
    String_catalog(
      id,
      name,
      brand,
      type,
      gauge_mm,
      construction,
      notes,
      price_min,
      price_max,
      is_active
    )
  }

  public fun <T : Any> getStringById(id: Long, mapper: (
    id: Long,
    name: String,
    brand: String,
    type: String,
    gauge_mm: Double?,
    construction: String?,
    notes: String?,
    price_min: Double?,
    price_max: Double?,
    is_active: Long,
  ) -> T): Query<T> = GetStringByIdQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2)!!,
      cursor.getString(3)!!,
      cursor.getDouble(4),
      cursor.getString(5),
      cursor.getString(6),
      cursor.getDouble(7),
      cursor.getDouble(8),
      cursor.getLong(9)!!
    )
  }

  public fun getStringById(id: Long): Query<String_catalog> = getStringById(id) { id_, name, brand,
      type, gauge_mm, construction, notes, price_min, price_max, is_active ->
    String_catalog(
      id_,
      name,
      brand,
      type,
      gauge_mm,
      construction,
      notes,
      price_min,
      price_max,
      is_active
    )
  }

  public fun getAllBrands(): Query<String> = Query(759_860_144, arrayOf("string_catalog"), driver,
      "StringCatalog.sq", "getAllBrands", """
  |SELECT DISTINCT brand FROM string_catalog 
  |WHERE is_active = 1
  |ORDER BY brand
  """.trimMargin()) { cursor ->
    cursor.getString(0)!!
  }

  public fun getAllTypes(): Query<String> = Query(1_288_283_669, arrayOf("string_catalog"), driver,
      "StringCatalog.sq", "getAllTypes", """
  |SELECT DISTINCT type FROM string_catalog 
  |WHERE is_active = 1
  |ORDER BY type
  """.trimMargin()) { cursor ->
    cursor.getString(0)!!
  }

  public fun insertString(
    name: String,
    brand: String,
    type: String,
    gauge_mm: Double?,
    construction: String?,
    notes: String?,
    price_min: Double?,
    price_max: Double?,
    is_active: Long,
  ) {
    driver.execute(-1_850_905_661, """
        |INSERT INTO string_catalog (
        |    name, brand, type, gauge_mm, construction, notes, price_min, price_max, is_active
        |) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """.trimMargin(), 9) {
          bindString(0, name)
          bindString(1, brand)
          bindString(2, type)
          bindDouble(3, gauge_mm)
          bindString(4, construction)
          bindString(5, notes)
          bindDouble(6, price_min)
          bindDouble(7, price_max)
          bindLong(8, is_active)
        }
    notifyQueries(-1_850_905_661) { emit ->
      emit("string_catalog")
    }
  }

  public fun updateString(
    name: String,
    brand: String,
    type: String,
    gauge_mm: Double?,
    construction: String?,
    notes: String?,
    price_min: Double?,
    price_max: Double?,
    is_active: Long,
    id: Long,
  ) {
    driver.execute(749_737_427, """
        |UPDATE string_catalog 
        |SET name = ?, brand = ?, type = ?, gauge_mm = ?, construction = ?, 
        |    notes = ?, price_min = ?, price_max = ?, is_active = ?
        |WHERE id = ?
        """.trimMargin(), 10) {
          bindString(0, name)
          bindString(1, brand)
          bindString(2, type)
          bindDouble(3, gauge_mm)
          bindString(4, construction)
          bindString(5, notes)
          bindDouble(6, price_min)
          bindDouble(7, price_max)
          bindLong(8, is_active)
          bindLong(9, id)
        }
    notifyQueries(749_737_427) { emit ->
      emit("string_catalog")
    }
  }

  public fun deactivateString(id: Long) {
    driver.execute(1_880_526_014, """
        |UPDATE string_catalog 
        |SET is_active = 0
        |WHERE id = ?
        """.trimMargin(), 1) {
          bindLong(0, id)
        }
    notifyQueries(1_880_526_014) { emit ->
      emit("string_catalog")
    }
  }

  private inner class GetStringsByBrandQuery<out T : Any>(
    public val brand: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("string_catalog", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("string_catalog", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-654_965_365, """
    |SELECT string_catalog.id, string_catalog.name, string_catalog.brand, string_catalog.type, string_catalog.gauge_mm, string_catalog.construction, string_catalog.notes, string_catalog.price_min, string_catalog.price_max, string_catalog.is_active FROM string_catalog 
    |WHERE brand = ? AND is_active = 1
    |ORDER BY name
    """.trimMargin(), mapper, 1) {
      bindString(0, brand)
    }

    override fun toString(): String = "StringCatalog.sq:getStringsByBrand"
  }

  private inner class GetStringsByTypeQuery<out T : Any>(
    public val type: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("string_catalog", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("string_catalog", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-851_868_490, """
    |SELECT string_catalog.id, string_catalog.name, string_catalog.brand, string_catalog.type, string_catalog.gauge_mm, string_catalog.construction, string_catalog.notes, string_catalog.price_min, string_catalog.price_max, string_catalog.is_active FROM string_catalog 
    |WHERE type = ? AND is_active = 1
    |ORDER BY brand, name
    """.trimMargin(), mapper, 1) {
      bindString(0, type)
    }

    override fun toString(): String = "StringCatalog.sq:getStringsByType"
  }

  private inner class SearchStringsQuery<out T : Any>(
    public val `value`: String,
    public val value_: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("string_catalog", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("string_catalog", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(284_495_681, """
    |SELECT string_catalog.id, string_catalog.name, string_catalog.brand, string_catalog.type, string_catalog.gauge_mm, string_catalog.construction, string_catalog.notes, string_catalog.price_min, string_catalog.price_max, string_catalog.is_active FROM string_catalog 
    |WHERE (name LIKE '%' || ? || '%' OR brand LIKE '%' || ? || '%') 
    |AND is_active = 1
    |ORDER BY brand, name
    """.trimMargin(), mapper, 2) {
      bindString(0, value)
      bindString(1, value_)
    }

    override fun toString(): String = "StringCatalog.sq:searchStrings"
  }

  private inner class GetStringByIdQuery<out T : Any>(
    public val id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("string_catalog", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("string_catalog", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-1_021_583_616, """
    |SELECT string_catalog.id, string_catalog.name, string_catalog.brand, string_catalog.type, string_catalog.gauge_mm, string_catalog.construction, string_catalog.notes, string_catalog.price_min, string_catalog.price_max, string_catalog.is_active FROM string_catalog 
    |WHERE id = ?
    """.trimMargin(), mapper, 1) {
      bindLong(0, id)
    }

    override fun toString(): String = "StringCatalog.sq:getStringById"
  }
}
