package com.app.hellokmmnetwork.news.data.repository

import com.app.hellokmmnetwork.network.AppRequest
import com.app.hellokmmnetwork.news.data.datasource.RemoteNewsDataSource

interface NewsFeedRepository {
    suspend fun fetchNews(): AppRequest
}

class NewsFeedRepositoryImpl(private val remoteNewsDataSource: RemoteNewsDataSource) :
    NewsFeedRepository {
    override suspend fun fetchNews(): AppRequest {
        val resp = remoteNewsDataSource.fetchNewsFeed()

        val data = if (resp.isSuccess && resp.getOrNull() != null) {
            resp.getOrNull()?.articles.let {
                AppRequest.Result(it)
            }
        } else {
            AppRequest.Error(resp.exceptionOrNull() ?: Exception("Something went wrong"))
        }
        return data
    }

}