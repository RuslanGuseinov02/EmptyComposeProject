package com.ruslan.huseynov.emptycomposeproject.util

internal sealed class ResourceState<out T> {
    data class Success<T>(val data: T) : ResourceState<T>()
    data class Error(val message: String) : ResourceState<Nothing>()
}