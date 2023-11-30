plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.jli.countrycollection"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jli.countrycollection"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    val activity_version = "1.8.1"
    val fragment_version = "1.6.2"
    val nav_version = "2.7.5"
    val coroutine_version = "1.7.3"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutine_version")


    // Base Ktx
    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.fragment:fragment-ktx:$fragment_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Network
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    // Logging
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Media
    implementation("io.coil-kt:coil:2.5.0")
    implementation("io.coil-kt:coil-svg:2.5.0")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}