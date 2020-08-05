package com.rudio.moviesdemo.di

import com.rudio.moviesdemo.networking.*
import com.rudio.moviesdemo.utils.BASE_URL_API
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ModuleNetwork {

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Singleton
    @Provides
    fun provideServiceTMDB(retrofit: Retrofit): ServiceTMDB {
        return retrofit.create(ServiceTMDB::class.java)
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(AdapterNullToDefaultString())
            .add(AdapterNullToDefaultDouble())
            .add(AdapterNullToDefaultInt())
            .build()
    }
}