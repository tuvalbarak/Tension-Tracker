package com.tuv.tensiontracker.data.repository

import android.content.Context
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.tuv.tensiontracker.data.database.TensionTrackerDatabase
import com.tuv.tensiontracker.data.mapper.DomainMapper
import com.tuv.tensiontracker.domain.model.StringModel
import com.tuv.tensiontracker.domain.model.StringType
import com.tuv.tensiontracker.domain.repository.StringCatalogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class StringCatalogRepositoryImpl(
    private val database: TensionTrackerDatabase,
    private val context: Context
) : StringCatalogRepository {
    
    private val queries = database.stringCatalogQueries
    private val json = Json { ignoreUnknownKeys = true }
    
    @Serializable
    private data class StringCatalogData(
        val strings: List<StringData>
    )
    
    @Serializable
    private data class StringData(
        val name: String,
        val brand: String,
        val type: String,
        val gauge_mm: Double? = null,
        val construction: String? = null,
        val notes: String? = null,
        val price_min: Double? = null,
        val price_max: Double? = null
    )
    
    override suspend fun insertString(string: StringModel): Long = withContext(Dispatchers.IO) {
        queries.insertString(
            name = string.name,
            brand = string.brand,
            type = string.type.displayName,
            gauge_mm = string.gaugeMm,
            construction = string.construction,
            notes = string.notes,
            price_min = string.priceMin,
            price_max = string.priceMax,
            is_active = if (string.isActive) 1L else 0L
        )
        // Use a simple counter since lastInsertRowId might not be available
        string.id
    }
    
    override suspend fun updateString(string: StringModel) = withContext(Dispatchers.IO) {
        queries.updateString(
            name = string.name,
            brand = string.brand,
            type = string.type.displayName,
            gauge_mm = string.gaugeMm,
            construction = string.construction,
            notes = string.notes,
            price_min = string.priceMin,
            price_max = string.priceMax,
            is_active = if (string.isActive) 1L else 0L,
            id = string.id
        )
    }
    
    override suspend fun deactivateString(stringId: Long) = withContext(Dispatchers.IO) {
        queries.deactivateString(stringId)
    }
    
    override suspend fun getStringById(stringId: Long): StringModel? = withContext(Dispatchers.IO) {
        queries.getStringById(stringId).executeAsOneOrNull()?.let { 
            DomainMapper.mapStringModel(it) 
        }
    }
    
    override fun getAllActiveStrings(): Flow<List<StringModel>> {
        return queries.getAllActiveStrings()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { dbStrings ->
                dbStrings.map { DomainMapper.mapStringModel(it) }
            }
    }
    
    override suspend fun getStringsByBrand(brand: String): List<StringModel> = withContext(Dispatchers.IO) {
        queries.getStringsByBrand(brand).executeAsList()
            .map { DomainMapper.mapStringModel(it) }
    }
    
    override suspend fun getStringsByType(type: StringType): List<StringModel> = withContext(Dispatchers.IO) {
        queries.getStringsByType(type.displayName).executeAsList()
            .map { DomainMapper.mapStringModel(it) }
    }
    
    override suspend fun searchStrings(query: String): List<StringModel> = withContext(Dispatchers.IO) {
        queries.searchStrings(query, query).executeAsList()
            .map { DomainMapper.mapStringModel(it) }
    }
    
    override suspend fun getAllBrands(): List<String> = withContext(Dispatchers.IO) {
        queries.getAllBrands().executeAsList()
    }
    
    override suspend fun getAllTypes(): List<StringType> = withContext(Dispatchers.IO) {
        queries.getAllTypes().executeAsList()
            .map { StringType.fromDisplayName(it) }
    }
    
    override suspend fun initializeFromAssets() = withContext(Dispatchers.IO) {
        try {
            // Check if catalog is already initialized
            val existingCount = queries.getAllActiveStrings().executeAsList().size
            if (existingCount > 0) {
                return@withContext // Already initialized
            }
            
            // Read JSON from assets
            val jsonString = context.assets.open("string_database.json").bufferedReader().use { it.readText() }
            val catalogData = json.decodeFromString<StringCatalogData>(jsonString)
            
            // Insert each string into the database
            catalogData.strings.forEach { stringData ->
                try {
                    val stringType = StringType.fromDisplayName(stringData.type)
                    queries.insertString(
                        name = stringData.name,
                        brand = stringData.brand,
                        type = stringType.displayName,
                        gauge_mm = stringData.gauge_mm,
                        construction = stringData.construction,
                        notes = stringData.notes,
                        price_min = stringData.price_min,
                        price_max = stringData.price_max,
                        is_active = 1L
                    )
                } catch (e: Exception) {
                    // Log error but continue with other strings
                    println("Error inserting string ${stringData.name}: ${e.message}")
                }
            }
        } catch (e: Exception) {
            println("Error initializing string catalog: ${e.message}")
        }
    }
}