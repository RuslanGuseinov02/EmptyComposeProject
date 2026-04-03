package com.ruslan.huseynov.emptycomposeproject.presentation.screen

import com.ruslan.huseynov.emptycomposeproject.domain.model.Clothes

internal object HomeReducer {

    fun getInitialState() = HomeUIState()

    fun HomeUIState.showLoading() = copy(isLoading = true)

    fun HomeUIState.hideLoading() = copy(isLoading = false)

    fun HomeUIState.setClothes(clothesList: List<Clothes>) = copy()
}