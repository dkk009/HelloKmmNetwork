package com.app.hellokmmnetwork.network

sealed class AppRequest {
    data class Result<T>(val result: T) : AppRequest()
    data class Error(val error: Throwable) : AppRequest()
    data class Loading(val message: String = ""): AppRequest()
}