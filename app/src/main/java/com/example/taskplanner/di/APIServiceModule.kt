package com.example.taskplanner.di

import com.example.taskplanner.repository.RetrofitGenerator
import com.example.taskplanner.repository.auth.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIServiceModule {

    @Provides
    @Singleton
    fun provideAuthService(): AuthService{
        return RetrofitGenerator.retrofit.create(AuthService::class.java)

    }






}