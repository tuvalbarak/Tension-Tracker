package com.tuv.tensiontracker.domain.repository

import com.tuv.tensiontracker.domain.model.StringModel
import com.tuv.tensiontracker.domain.model.StringType
import kotlinx.coroutines.flow.Flow

interface StringCatalogRepository {
    
    suspend fun insertString(string: StringModel): Long
    
    suspend fun updateString(string: StringModel)
    
    suspend fun deactivateString(stringId: Long)
    
    suspend fun getStringById(stringId: Long): StringModel?
    
    fun getAllActiveStrings(): Flow<List<StringModel>>
    
    suspend fun getStringsByBrand(brand: String): List<StringModel>
    
    suspend fun getStringsByType(type: StringType): List<StringModel>
    
    suspend fun searchStrings(query: String): List<StringModel>
    
    suspend fun getAllBrands(): List<String>
    
    suspend fun getAllTypes(): List<StringType>
    
    suspend fun initializeFromAssets()
}