package com.exsolv.tempglovo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exsolv.tempglovo.model.University
import com.exsolv.tempglovo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val mainRepository: Repository
): ViewModel(){
    private val _stateFlow: MutableSharedFlow<DataState<List<University>>> = MutableSharedFlow()
    val stateFlow: SharedFlow<DataState<List<University>>>
        get() = _stateFlow

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetUniversityEvent ->{
                    mainRepository.getUnis()
                        .onEach { dataState ->
                            _stateFlow.emit(dataState)
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None ->{}
            }
        }
    }
}

sealed class MainStateEvent {
    object GetUniversityEvent: MainStateEvent()
    object None: MainStateEvent()
}