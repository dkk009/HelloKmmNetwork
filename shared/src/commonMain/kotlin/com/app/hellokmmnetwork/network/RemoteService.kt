package com.app.hellokmmnetwork.network

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
fun createJson() = Json { isLenient= true; ignoreUnknownKeys = true; prettyPrint = true; explicitNulls = false  }

fun createHttpClient(json: Json) = HttpClient{
    install(Logging)
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = "newsapi.org"
            path("v2/")
            parameters.append("apiKey","afe8dfde4c484ab0b3ffd11601a7aa9d")
        }
    }
    install(ContentNegotiation){
        json(json)
    }
}