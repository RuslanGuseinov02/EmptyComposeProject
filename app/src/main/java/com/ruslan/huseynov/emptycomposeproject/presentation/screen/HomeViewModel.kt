package com.ruslan.huseynov.emptycomposeproject.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruslan.huseynov.emptycomposeproject.di.viewModelModule
import com.ruslan.huseynov.emptycomposeproject.domain.usecase.GetClothesUseCase
import com.ruslan.huseynov.emptycomposeproject.presentation.screen.HomeReducer.hideLoading
import com.ruslan.huseynov.emptycomposeproject.presentation.screen.HomeReducer.setClothes
import com.ruslan.huseynov.emptycomposeproject.presentation.screen.HomeReducer.showLoading
import com.ruslan.huseynov.emptycomposeproject.util.onError
import com.ruslan.huseynov.emptycomposeproject.util.onSuccess
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val getClothesUseCase: GetClothesUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    private var _sideEffect = MutableSharedFlow<HomeSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    internal fun onAction(action: HomeAction) {
        when(action) {
            is HomeAction.GetData -> {
                getData()
            }
        }
    }

    private fun getData() = viewModelScope.launch {
        _uiState.update { it.showLoading() }
        getClothesUseCase().collect { result ->
            result.onSuccess { data ->
                println("data success")
                _uiState.update { it.setClothes(data.data) }
            }.onError { error ->
                println(error)
                println("data error")
                _sideEffect.tryEmit(HomeSideEffect.ShowMessage(error))
            }
        }
        _uiState.update { it.hideLoading() }
    }
}