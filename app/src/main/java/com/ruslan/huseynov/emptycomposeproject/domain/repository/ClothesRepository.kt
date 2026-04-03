package com.ruslan.huseynov.emptycomposeproject.domain.repository

import com.ruslan.huseynov.emptycomposeproject.domain.model.Clothes
import com.ruslan.huseynov.emptycomposeproject.util.ResourceState
import kotlinx.coroutines.flow.Flow

internal interface ClothesRepository {
    fun getClothes(): Flow<ResourceState<Clothes>>
}