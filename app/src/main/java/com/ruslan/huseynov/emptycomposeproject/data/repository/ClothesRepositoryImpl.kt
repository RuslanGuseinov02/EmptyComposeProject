package com.ruslan.huseynov.emptycomposeproject.data.repository

import com.ruslan.huseynov.emptycomposeproject.data.mapper.toDomain
import com.ruslan.huseynov.emptycomposeproject.data.remote.ApiService
import com.ruslan.huseynov.emptycomposeproject.domain.model.Clothes
import com.ruslan.huseynov.emptycomposeproject.domain.repository.ClothesRepository
import com.ruslan.huseynov.emptycomposeproject.util.ResourceState
import com.ruslan.huseynov.emptycomposeproject.util.safeApiCall
import kotlinx.coroutines.flow.Flow

internal class ClothesRepositoryImpl(
    private val apiService: ApiService
) : ClothesRepository {
    override fun getClothes(): Flow<ResourceState<Clothes>> {
        return safeApiCall {
            apiService.getClothes().toDomain()
        }
    }
}