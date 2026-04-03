package com.ruslan.huseynov.emptycomposeproject.presentation.screen

import androidx.compose.runtime.Immutable
import com.ruslan.huseynov.emptycomposeproject.domain.model.Clothes

@Immutable
internal data class HomeUIState(
    val isLoading: Boolean = false,
    val clothesList: List<Clothes> = emptyList()
)

@Immutable
internal sealed interface HomeAction {
    data object GetData : HomeAction
}

@Immutable
internal sealed interface HomeSideEffect {
    data class ShowMessage(val message: String) : HomeSideEffect
}