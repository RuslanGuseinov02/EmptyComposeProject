package com.ruslan.huseynov.emptycomposeproject.data.mapper

import com.ruslan.huseynov.emptycomposeproject.data.model.CategoryDTO
import com.ruslan.huseynov.emptycomposeproject.data.model.ClothesDTO
import com.ruslan.huseynov.emptycomposeproject.domain.model.Clothes
import com.ruslan.huseynov.emptycomposeproject.util.orFalse

internal fun ClothesDTO.toDomain(): Clothes {
    return Clothes(
        success = success.orFalse(),
        data = data?.map { it.toDomain() }.orEmpty(),
        message = message.orEmpty()
    )
}