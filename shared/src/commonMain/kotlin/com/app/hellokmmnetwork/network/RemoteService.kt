package com.app.hellokmmnetwork.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun createJson() = Json { isLenient= true; ignoreUnknownKeys = true }

fun createHttpClient(json: Json) = HttpClient{
    expectSuccess= true
    install(ContentNegotiation){
        json(json)
    }
}