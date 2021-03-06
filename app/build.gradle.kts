plugins {
    id(Plugins.application)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinParcelize)
    id(Plugins.navigationSageArgs)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
    id(Plugins.checkDependencyUpdates) version Versions.checkDependencyUpdates
}

android {
    compileSdkVersion(Android.compileSdk)
    buildToolsVersion(Android.buildTools)

    defaultConfig {
        applicationId = Android.applicationId
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = Android.versionCode
        versionName = Android.versionName
        testInstrumentationRunner = Android.testInstrumentationRunner
    }

    buildTypes {

        getByName("release") {
            isMinifyEnabled = Android.minifyEnabled
            proguardFiles(getDefaultProguardFile(Android.proguardOptimize), Android.proguardRules)
        }
    }

    buildFeatures {
        dataBinding = Android.dataBindingEnabled
    }

    compileOptions {
        sourceCompatibility = Android.java
        targetCompatibility = Android.java
    }

    kotlinOptions {
        jvmTarget = Android.javaString
    }
}

dependencies {
    implementation(project(Modules.data))
    implementation(fileTree(Dependencies.fileTree))
    implementation(Dependencies.appCompat)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.recyclerView)
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
    implementation(Dependencies.viewPager)
    implementation(Dependencies.material)
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.jUnitAndroid)
    androidTestImplementation(Dependencies.espressoAndroid)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiRetrofit)
    implementation(Dependencies.moshi)
    kapt(Dependencies.moshiCodegenKapt)
    implementation(Dependencies.picasso)
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltAndroidCompilerKapt)
    implementation(Dependencies.hiltViewModel)
    kapt(Dependencies.hiltCompilerKapt)
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompilerKapt)
    implementation(Dependencies.viewModel)
    implementation(Dependencies.liveData)
    implementation(Dependencies.coroutinesAndroid)
}