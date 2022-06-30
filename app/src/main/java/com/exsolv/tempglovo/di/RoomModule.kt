package com.exsolv.tempglovo.di

import android.content.Context
import androidx.room.Room
import com.exsolv.tempglovo.room.UniversityDao
import com.exsolv.tempglovo.room.UniversityDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideUniversityDB(@ApplicationContext context: Context): UniversityDatabase {
        return Room.databaseBuilder(
            context,
            UniversityDatabase::class.java,
            UniversityDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUniversityDao(universityDatabase: UniversityDatabase): UniversityDao {
        return universityDatabase.universityDao()
    }
}