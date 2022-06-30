package com.exsolv.tempglovo.repository

import com.exsolv.tempglovo.model.University
import com.exsolv.tempglovo.ui.DataState
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getUnis(): Flow<DataState<List<University>>>

}