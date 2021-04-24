package com.jegadeesan.apod.domain.usecase

import java.lang.Exception

interface UseCase<P, R> {
    suspend fun execute(param: P): R
}

sealed class Result<out R>{

    data class Success<out T>(val data: T): Result<T>()
    data class Error(val exception: Exception): Result<Nothing>()
}