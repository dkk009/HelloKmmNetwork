package com.app.hellokmmnetwork.news.data.datasource

import com.app.hellokmmnetwork.news.data.entity.NewsFeedResp
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent

interface RemoteNewsDataSource {
    suspend fun fetchNewsFeed(): Result<NewsFeedResp>
}

private val NEWS_FEED_URL = ""

class RemoteNewsDataSourceImpl(private val client: HttpClient) : KoinComponent,
    RemoteNewsDataSource {
    override suspend fun fetchNewsFeed(): Result<NewsFeedResp> {
        return try {
            val response = client.get(NEWS_FEED_URL)
            val data = response.body<NewsFeedResp>()
            Result.success(data)
        } catch (exc: Exception) {
            Result.failure(exc)
        }
    }
}
