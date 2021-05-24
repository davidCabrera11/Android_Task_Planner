package com.example.taskplanner.di


import android.content.Context
import androidx.room.Room
import com.example.taskplanner.repository.AppDatabase
import com.example.taskplanner.repository.model.dao.UserDao
import com.example.taskplanner.storage.LocalStorage
import com.example.taskplanner.storage.Storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideStorage(@ApplicationContext context: Context) : Storage{
        return LocalStorage(context)
    }



    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context):AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-taskplanner"
        ).build()


    }


    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase):UserDao{
        return appDatabase.userDao()

    }




}