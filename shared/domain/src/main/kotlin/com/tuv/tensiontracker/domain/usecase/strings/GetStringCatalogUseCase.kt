package com.tuv.tensiontracker.domain.usecase.strings

import com.tuv.tensiontracker.domain.model.StringModel
import com.tuv.tensiontracker.domain.model.StringType
import com.tuv.tensiontracker.domain.repository.StringCatalogRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStringCatalogUseCase @Inject constructor(
    private val stringCatalogRepository: StringCatalogRepository
) {
    
    fun getAllStrings(): Flow<List<StringModel>> {
        return stringCatalogRepository.getAllActiveStrings()
    }
    
    suspend fun ensureInitialized() {
        try {
            stringCatalogRepository.initializeFromAssets()
        } catch (e: Exception) {
            println("Failed to initialize string catalog: ${e.message}")
            e.printStackTrace()
        }
    }
    
    suspend fun getStringsByType(type: StringType): List<StringModel> {
        return stringCatalogRepository.getStringsByType(type)
    }
    
    suspend fun getStringsByBrand(brand: String): List<StringModel> {
        return stringCatalogRepository.getStringsByBrand(brand)
    }
    
    suspend fun searchStrings(query: String): List<StringModel> {
        return stringCatalogRepository.searchStrings(query)
    }
    
    suspend fun getAllBrands(): List<String> {
        return stringCatalogRepository.getAllBrands()
    }
}