package com.rudio.moviesdemo.framework.di

import com.rudio.moviesdemo.data.remote.RemoteDataSource
import com.rudio.moviesdemo.framework.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ModuleNetworkBinders {

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}