plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.test.amsi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.test.amsi"
        minSdk = 24
        targetSdk = 33
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
        viewBinding = true
    }
}

dependencies {

    implementation(project(":common"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":features"))
    implementation(project(":features:auth"))
    implementation(project(":features:info"))
    implementation(project(":features:onboarding"))
    implementation(project(":features:splash"))
    implementation(project(":features:main"))
    implementation(project(":features:events"))
    implementation(project(":features:feed"))
    implementation(project(":features:jobs"))
    implementation(project(":features:profile"))
    implementation(project(":navigation"))
    implementation(project(":picker"))
}