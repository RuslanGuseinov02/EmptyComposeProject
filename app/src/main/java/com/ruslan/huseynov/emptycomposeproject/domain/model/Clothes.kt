package com.ruslan.huseynov.emptycomposeproject.domain.model

internal data class Clothes(
    val success: Boolean,
    val data: List<Clothes>,
    val message: String
)

internal data class Category(
    val id: Int,
    val parentId: Int,
    val name: String,
    val slug: String,
    val iconUrl: String,
    val imageUrl: String,
    val description: String,
    val isActive: Boolean,
    val sortOrder: Int,
    val childCount: Int,
    val children: List<Clothes>
)