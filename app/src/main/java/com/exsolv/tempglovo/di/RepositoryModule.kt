package com.exsolv.tempglovo.di

import com.exsolv.tempglovo.repository.MainRepository
import com.exsolv.tempglovo.repository.Repository
import com.exsolv.tempglovo.retrofit.UniversityRetrofit
import com.exsolv.tempglovo.room.CacheMapper
import com.exsolv.tempglovo.room.UniversityDao
import com.exsolv.tempglovo.util.NetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        universityDao: UniversityDao,
        retrofit: UniversityRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): Repository = MainRepository(
            retrofit,
            universityDao,
            cacheMapper,
            networkMapper
        )
}