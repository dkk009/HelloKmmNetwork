package com.app.hellokmmnetwork.news.data.repository

import com.app.hellokmmnetwork.news.data.entity.Articles
import com.app.hellokmmnetwork.news.data.datasource.RemoteNewsDataSource

interface NewsFeedRepository {
    suspend fun fetchNews(): Result<List<Articles>>
}

class NewsFeedRepositoryImpl(private val remoteNewsDataSource: RemoteNewsDataSource) :
    NewsFeedRepository {
    override suspend fun fetchNews(): Result<List<Articles>> {
        val resp = remoteNewsDataSource.fetchNewsFeed()
        val data = if (resp.isSuccess && resp.getOrNull() != null) {
            resp.map { (it.articles) }
        } else {
            Result.failure(resp.exceptionOrNull() ?: Exception("Something went wrong"))
        }
        return data
    }

}