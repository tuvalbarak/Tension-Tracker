plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.tuv.tensiontracker.domain"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
    
    // DateTime
    implementation(libs.kotlinx.datetime)
    
    // Serialization
    implementation(libs.kotlinx.serialization.json)
    
    // DI
    implementation(libs.hilt.android)
    
    // Testing
    testImplementation(libs.junit)
}