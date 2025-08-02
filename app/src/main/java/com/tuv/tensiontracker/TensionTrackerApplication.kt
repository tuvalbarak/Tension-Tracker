package com.tuv.tensiontracker

import android.app.Application
import com.tuv.tensiontracker.domain.repository.StringCatalogRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class TensionTrackerApplication : Application() {
    
    @Inject
    lateinit var stringCatalogRepository: StringCatalogRepository
    
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize string catalog from assets on first run
        applicationScope.launch {
            stringCatalogRepository.initializeFromAssets()
        }
    }
}