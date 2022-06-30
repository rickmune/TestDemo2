package com.exsolv.tempglovo.repository

import com.exsolv.tempglovo.model.University
import com.exsolv.tempglovo.retrofit.UniversityRetrofit
import com.exsolv.tempglovo.room.CacheMapper
import com.exsolv.tempglovo.room.UniversityDao
import com.exsolv.tempglovo.ui.DataState
import com.exsolv.tempglovo.util.NetworkMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class MainRepository
@Inject
constructor(
    private val retrofit: UniversityRetrofit,
    private val universityDao: UniversityDao,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
): Repository{

    override suspend fun getUnis(): Flow<DataState<List<University>>> = flow{
        emit(DataState.Loading)
        try {
            val networkUni = retrofit.get()
            val universities = networkMapper.mapFromEntity(networkUni)
            for (university in universities){
                universityDao.insertUni(cacheMapper.mapToEntity(university))
            }
            val cachedUni = universityDao.getUni()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedUni.first())))
        } catch (exception: Exception){
            emit(DataState.Error(exception))
        }
    }
}