package com.ruslan.huseynov.emptycomposeproject.data.model

internal data class ClothesDTO(
    val success: Boolean? = null,
    val data: List<ClothesDTO>? = null,
    val message: String? = null
)

internal data class CategoryDTO(
    val id: Int? = null,
    val parentId: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val iconUrl: String? = null,
    val imageUrl: String? = null,
    val description: String? = null,
    val isActive: Boolean? = null,
    val sortOrder: Int? = null,
    val childCount: Int? = null,
    val children: List<ClothesDTO>? = null
)
