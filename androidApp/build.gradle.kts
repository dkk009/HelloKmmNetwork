plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.app.hellokmmnetwork.android"
    compileSdk = 32
    defaultConfig {
        applicationId = "com.app.hellokmmnetwork.android"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    val composeVersion  = "1.2.1"
    val composeActivityVersion = "1.5.1"
    val composeNavigation = "2.5.2"
    val coroutine = "1.6.4"
    val koinAndroid = "3.2.2"
    val koinAndroidCompose = "3.2.1"
    val coilVersion = "2.2.2"
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.activity:activity-compose:$composeActivityVersion")
    implementation("androidx.navigation:navigation-compose:$composeNavigation")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine")

    implementation("io.insert-koin:koin-android:$koinAndroid")
    /*implementation("io.insert-koin:koin-androidx-navigation:$koinAndroid")*/
    implementation("io.insert-koin:koin-androidx-compose:$koinAndroidCompose")

    implementation("io.coil-kt:coil-compose:$coilVersion")
}