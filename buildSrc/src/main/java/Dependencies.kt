import org.gradle.api.JavaVersion

object Plugins {
    const val application = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtentions = "kotlin-android-extensions"
    const val navigationSageArgs= "androidx.navigation.safeargs.kotlin"
    const val kotlinKapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"
}

object Android {
    const val compileSdk = 30
    const val buildTools = "29.0.3"

    const val applicationId = "com.rudio.moviesdemo"
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val minifyEnabled = false
    const val proguardOptimize = "proguard-android-optimize.txt"
    const val proguardRules = "proguard-rules.pro"
    const val dataBindingEnabled = true
    val java = JavaVersion.VERSION_1_8
    val javaString = JavaVersion.VERSION_1_8.toString()
}

object Dependencies {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlinGradle= "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val navigationSafeArgsGradle = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    val hiltGradle = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appCompat = "androidx.appcompat:appcompat:1.2.0"
    val coreKtx = "androidx.core:core-ktx:1.3.1"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val viewPager = "androidx.viewpager2:viewpager2:1.0.0"
    val material = "com.google.android.material:material:1.3.0-alpha02"
    val jUnit = "junit:junit:4.13"
    val jUnitAndroid = "androidx.test.ext:junit:1.1.1"
    val espressoAndroid = "androidx.test.espresso:espresso-core:3.2.0"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val moshiRetrofit = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    val moshiCodegenKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    val picasso = "com.squareup.picasso:picasso:2.71828"
    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltAndroidCompilerKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02"
    val hiltCompilerKapt = "androidx.hilt:hilt-compiler:1.0.0-alpha02"
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val roomCompilerKapt = "androidx.room:room-compiler:${Versions.room}"
    val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object Versions {
    const val gradle = "4.0.1"
    const val kotlin = "1.3.72"
    const val retrofit = "2.8.2"
    const val navigation = "2.3.0"
    const val room = "2.2.5"
    const val hilt = "2.28-alpha"
    const val coroutines = "1.3.7"
    const val lifecycle = "2.2.0"
    const val moshi = "1.9.3"
}