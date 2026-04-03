package com.ruslan.huseynov.emptycomposeproject.util

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

internal fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

// Null Safety

internal fun Int?.orZero(): Int {
    return this ?: ZERO
}

internal fun Boolean?.orFalse(): Boolean {
    return this ?: false
}

internal fun Boolean?.orTrue(): Boolean {
    return this ?: true
}

internal fun <T> safeApiCall(
    call: suspend () -> T
): Flow<ResourceState<T>> = flow {
    try {
        val result = call()
        emit(ResourceState.Success(result))
    }catch (e: Exception) {
        emit(ResourceState.Error(e.message.orEmpty()))
    }
}.flowOn(Dispatchers.IO)

internal fun<T> ResourceState<T>.onSuccess(
    action: (T) -> Unit
): ResourceState<T> {
    if (this is ResourceState.Success) {
        action(data)
    }
    return this
}

internal fun <T> ResourceState<T>.onError(
    action: (String) -> Unit
): ResourceState<T> {
    if (this is ResourceState.Error) {
        action(message)
    }
    return this
}


