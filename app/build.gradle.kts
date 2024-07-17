plugins {
    alias(notation = libs.plugins.android.application)
    alias(notation = libs.plugins.jetbrains.kotlin.android)
    alias(notation = libs.plugins.ksp)
    alias(notation = libs.plugins.kotlinx.serialization)
}

android {
    namespace = "cifor.icraf.objects"
    compileSdk = 34

    defaultConfig {
        applicationId = "cifor.icraf.objects"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                files = arrayOf(
                    getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
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

    implementation(dependencyNotation = libs.androidx.core.ktx)
    implementation(dependencyNotation = libs.androidx.appcompat)
    implementation(dependencyNotation = libs.material)

    implementation(dependencyNotation = libs.bundles.networking)
    implementation(dependencyNotation = libs.bundles.koin)
    implementation(dependencyNotation = libs.room.ktx)
    implementation(dependencyNotation = libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(dependencyNotation = libs.splash.screen)
    implementation(dependencyNotation = libs.timber)

    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    debugImplementation(dependencyNotation = libs.leak.canary)

}