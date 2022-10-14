package com.app.hellokmmnetwork.news.data.entity

@kotlinx.serialization.Serializable
data class NewsFeedResp(val status: String, val totalResults: Int, val articles: List<Articles>)

@kotlinx.serialization.Serializable
data class Articles(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val content: String?
)

@kotlinx.serialization.Serializable
data class Source(val id: String?, val name: String)