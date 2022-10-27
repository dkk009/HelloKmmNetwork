package com.app.hellokmmnetwork.news.data.entity
import kotlinx.serialization.Serializable

@Serializable
data class NewsFeedResp(val status: String, val totalResults: Int, val articles: List<Articles>)

@Serializable
data class Articles(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val content: String?
)

@Serializable
data class Source(val id: String?, val name: String)