package com.exsolv.tempglovo.repository

import com.exsolv.tempglovo.model.University
import com.exsolv.tempglovo.ui.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.SocketException

class FakeRepository: Repository {

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean){
        shouldReturnNetworkError = value
    }

    override suspend fun getUnis(): Flow<DataState<List<University>>> = flow{
        emit(DataState.Loading)
        if(shouldReturnNetworkError){
            emit(DataState.Error(SocketException()))
        } else {
            val university = University("", "", "JKUAT", "Kenya", "KE")
            val university1 = University("", "", "Nairobi", "Kenya", "KE")
            val university2 = University("", "", "KU", "Kenya", "KE")
            val list = mutableListOf<University>(university, university1, university2)
            emit(DataState.Success(list))
        }
    }
}