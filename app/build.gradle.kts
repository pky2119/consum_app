plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //파이어베이스
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.consum_app"
    compileSdk = 33

    // 파이어베이스
    // viewBinding {
    //    enable = true
    //}
    //

    dataBinding {
        enable = true
    }

    defaultConfig {
        applicationId = "com.example.consum_app"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // 파이어베이스
    implementation(platform("com.google.firebase:firebase-bom:32.5.0"))
    implementation("com.google.firebase:firebase-analytics")

    // 파이어베이스 _ 로그인/인증
    implementation("com.google.firebase:firebase-auth-ktx::22.2.0")
    implementation("com.google.android.gms:play-services-auth:20.7.0")

    implementation ("androidx.multidex:multidex:2.0.1")


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}