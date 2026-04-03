package com.ruslan.huseynov.emptycomposeproject.data.remote

import com.ruslan.huseynov.emptycomposeproject.data.model.ClothesDTO
import retrofit2.http.GET
import retrofit2.http.Header

internal interface ApiService {
    @GET("/catalog/categories/tree")
    suspend fun getClothes(
        //@Header("X-API-Key") token: String = "brdntp_sk_a7f3e2c1d4b8a9e6f0c3d5b7a1e4f2c8"
    ): ClothesDTO
}