package com.rudio.moviesdemo.di

import com.rudio.moviesdemo.networking.ServiceTMDB
import com.rudio.moviesdemo.utils.BASE_URL_API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ModuleNetwork {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideServiceTMDB(retrofit: Retrofit): ServiceTMDB {
        return retrofit.create(ServiceTMDB::class.java)
    }
}