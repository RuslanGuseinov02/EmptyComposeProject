package com.ruslan.huseynov.emptycomposeproject.di

import com.ruslan.huseynov.emptycomposeproject.presentation.screen.HomeViewModel
import org.koin.dsl.module

internal val viewModelModule = module {
    single { HomeViewModel(get()) }
}