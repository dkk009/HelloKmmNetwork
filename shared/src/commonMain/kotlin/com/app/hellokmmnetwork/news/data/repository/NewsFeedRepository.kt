package com.app.hellokmmnetwork.news.data.repository

import com.app.hellokmmnetwork.network.AppRequest
import com.app.hellokmmnetwork.news.data.datasource.RemoteNewsDataSource
import com.app.hellokmmnetwork.news.data.entity.Articles
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy

interface NewsFeedRepository {
    suspend fun fetchNews(): AppRequest
}

class NewsFeedRepositoryImpl(
    private val remoteNewsDataSource: RemoteNewsDataSource,
    private val realm: Realm
) :
    NewsFeedRepository {
    override suspend fun fetchNews(): AppRequest {
        val localData = realm.query(clazz = Articles::class).find()
        val data = if (localData.isEmpty()) {
            val resp = remoteNewsDataSource.fetchNewsFeed()

            if (resp.isSuccess && resp.getOrNull() != null) {
                resp.getOrNull()?.articles.let {
                    realm.write {
                        it?.forEach {
                            copyToRealm(it, UpdatePolicy.ALL)
                        }
                    }
                    AppRequest.Result(it)
                }
            } else {
                AppRequest.Error(resp.exceptionOrNull() ?: Exception("Something went wrong"))
            }
        } else {
            AppRequest.Result(localData)
        }
        return data
    }

}