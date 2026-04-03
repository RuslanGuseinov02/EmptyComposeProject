package com.ruslan.huseynov.emptycomposeproject.di

import com.ruslan.huseynov.emptycomposeproject.data.repository.ClothesRepositoryImpl
import com.ruslan.huseynov.emptycomposeproject.domain.repository.ClothesRepository
import org.koin.dsl.module

internal val repositoryModule = module {
    single<ClothesRepository> { ClothesRepositoryImpl(get()) }
}