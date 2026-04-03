package com.ruslan.huseynov.emptycomposeproject.domain.usecase

import com.ruslan.huseynov.emptycomposeproject.domain.model.Clothes
import com.ruslan.huseynov.emptycomposeproject.domain.repository.ClothesRepository
import com.ruslan.huseynov.emptycomposeproject.util.ResourceState
import kotlinx.coroutines.flow.Flow

internal class GetClothesUseCase(private val repository: ClothesRepository) {
    operator fun invoke(): Flow<ResourceState<Clothes>> {
        return repository.getClothes()
    }
}