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
    
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    
    override fun onCreate() {
        super.onCreate()
        
        // Note: String catalog will be initialized when first accessed through repositories
        // This avoids Hilt injection timing issues in Application.onCreate()
    }
}