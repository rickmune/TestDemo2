package com.exsolv.tempglovo.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.exsolv.tempglovo.MainCoroutineRule
import com.exsolv.tempglovo.repository.FakeRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelError: MainViewModel
    private lateinit var fakeRepository: FakeRepository

    @Before
    fun setUp(){
        fakeRepository = FakeRepository()
        viewModel = MainViewModel(FakeRepository())
        fakeRepository.setShouldReturnNetworkError(true)
        viewModelError = MainViewModel(fakeRepository)
    }

    @Test
    fun `When event GetUniversityEvent emit, LOADING state first`() = runTest {
        viewModel.setStateEvent(MainStateEvent.GetUniversityEvent)
        val loading = viewModel.stateFlow.first()
        assertThat(loading == DataState.Loading).isTrue()
    }

    @Test
    fun `When GetUniversityEvent emit, SUCCESS after LOADING state`() = runTest {
        viewModel.setStateEvent(MainStateEvent.GetUniversityEvent)
        val success = viewModel.stateFlow.drop(1).first()
        assertThat(success is DataState.Success).isTrue()
    }

    @Test
    fun `When Network Fails event GetUniversityEvent emits, Error state after Loading`() = runTest {
        viewModelError.setStateEvent(MainStateEvent.GetUniversityEvent)
        val error = viewModelError.stateFlow.drop(1).first()
        assertThat(error is DataState.Error).isTrue()
    }
}