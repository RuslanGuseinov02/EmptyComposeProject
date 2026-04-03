package com.ruslan.huseynov.emptycomposeproject.di

import com.ruslan.huseynov.emptycomposeproject.domain.usecase.GetClothesUseCase
import org.koin.dsl.module

internal val useCaseModule = module {
    single { GetClothesUseCase(get()) }
}