import org.gradle.api.JavaVersion

object Plugins {
    const val application = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinParcelize = "kotlin-parcelize"
    const val navigationSageArgs= "androidx.navigation.safeargs.kotlin"
    const val kotlinKapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"
    const val kotlin = "kotlin"
    const val javaLibrary = "java-library"
    const val checkDependencyUpdates = "name.remal.check-dependency-updates"
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
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradle= "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafeArgsGradle = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val hiltGradle = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    val fileTree = mapOf("dir" to "libs", "include" to "*.jar")
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    const val coreKtx = "androidx.core:core-ktx:1.3.2"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val viewPager = "androidx.viewpager2:viewpager2:1.0.0"
    const val material = "com.google.android.material:material:1.3.0-alpha02"
    const val jUnit = "junit:junit:4.13.1"
    const val jUnitAndroid = "androidx.test.ext:junit:1.1.2"
    const val espressoAndroid = "androidx.test.espresso:espresso-core:3.3.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiRetrofit = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiCodegenKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val picasso = "com.squareup.picasso:picasso:2.71828"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltAndroidCompilerKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02"
    const val hiltCompilerKapt = "androidx.hilt:hilt-compiler:1.0.0-alpha02"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompilerKapt = "androidx.room:room-compiler:${Versions.room}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object Versions {
    const val gradle = "4.1.1"
    const val kotlin = "1.4.21"
    const val retrofit = "2.9.0"
    const val navigation = "2.3.2"
    const val room = "2.2.6"
    const val hilt = "2.28-alpha"
    const val coroutines = "1.4.2"
    const val lifecycle = "2.2.0"
    const val moshi = "1.11.0"
    const val checkDependencyUpdates = "1.1.6"
}

object Modules {
    const val app = ":app"
    const val data = ":data"
    const val domain = ":domain"
}