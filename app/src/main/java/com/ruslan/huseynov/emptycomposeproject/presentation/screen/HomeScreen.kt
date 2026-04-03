package com.ruslan.huseynov.emptycomposeproject.presentation.screen

import androidx.collection.intSetOf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ruslan.huseynov.emptycomposeproject.presentation.component.LoadingContainer
import com.ruslan.huseynov.emptycomposeproject.util.showToast
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.onAction(HomeAction.GetData)
    }

    LaunchedEffect(true) {
        viewModel.sideEffect.collect { effect ->
            when(effect) {
                is HomeSideEffect.ShowMessage -> {
                    context.showToast(effect.message)
                }
            }
        }
    }
    LoadingContainer(state.isLoading) {
        HomeContent(
            state = state,
            onAction = viewModel::onAction
        )
    }
}

@Composable
private fun HomeContent(
    state: HomeUIState,
    onAction: (HomeAction) -> Unit
) {

}

@Preview
@Composable
private fun Demo() {
    HomeContent(
        state = HomeReducer.getInitialState(),
        onAction = {}
    )
}