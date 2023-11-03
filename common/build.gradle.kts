plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.test.common"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        viewBinding = true
    }
}

dependencies {

    api("androidx.core:core-ktx:1.9.0")
    api("androidx.appcompat:appcompat:1.6.1")
    api("com.google.android.material:material:1.10.0")
    api("com.github.kirich1409:viewbindingpropertydelegate-full:1.5.9")
    api("dev.chrisbanes.insetter:insetter:0.6.1")

    api("io.coil-kt:coil:2.4.0")
    api(project(":navigation"))

    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")


    api("androidx.activity:activity-ktx:1.3.0")
    api("androidx.fragment:fragment-ktx:1.5.1")

    api("androidx.recyclerview:recyclerview:1.3.1")

    api("com.google.android.gms:play-services-maps:17.0.0")

    api("io.insert-koin:koin-core:3.5.0")
    api("io.insert-koin:koin-android:3.5.0")
}