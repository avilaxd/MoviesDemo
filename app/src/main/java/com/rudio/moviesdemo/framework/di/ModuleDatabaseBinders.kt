package com.rudio.moviesdemo.framework.di

import com.rudio.moviesdemo.data.local.ILocalDataSource
import com.rudio.moviesdemo.framework.local.LocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ModuleDatabaseBinders {

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDataSource: LocalDataSource): ILocalDataSource
}