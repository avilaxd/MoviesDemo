package com.rudio.moviesdemo.ui

import android.app.Application
import com.rudio.moviesdemo.di.AppComponent
import com.rudio.moviesdemo.di.DaggerAppComponent

class AppMain : Application() {
    val appComponent: AppComponent by lazy { DaggerAppComponent.create() }
}