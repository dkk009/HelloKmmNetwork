package com.app.hellokmmnetwork.news.data.entity

data class NewsFeedResp(val status: String, val totalResults: Int, val articles: List<Articles>)
data class Articles(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val content: String
)

data class Source(val id: String?, val name: String)