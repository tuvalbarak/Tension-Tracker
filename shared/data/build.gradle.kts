plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.sqldelight)
    id("kotlin-kapt")
}

android {
    namespace = "com.tuv.tensiontracker.data"
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

sqldelight {
    databases {
        create("TensionTrackerDatabase") {
            packageName.set("com.tuv.tensiontracker.data.database")
            dialect("app.cash.sqldelight:sqlite-3-38-dialect:2.0.2")
        }
    }
}

dependencies {
    // Domain module
    implementation(project(":shared:domain"))
    
    // SQLDelight
    implementation(libs.sqldelight.android.driver)
    implementation(libs.sqldelight.coroutines.extensions)
    implementation(libs.sqldelight.primitive.adapters)
    
    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
    
    // DateTime
    implementation(libs.kotlinx.datetime)
    
    // Serialization
    implementation(libs.kotlinx.serialization.json)
    
    // DI
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    
    // Testing
    testImplementation(libs.junit)
}