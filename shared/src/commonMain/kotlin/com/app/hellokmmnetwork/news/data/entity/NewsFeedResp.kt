package com.app.hellokmmnetwork.news.data.entity

import io.realm.kotlin.types.RealmObject
import kotlinx.serialization.Serializable

@Serializable
data class NewsFeedResp(val status: String, val totalResults: Int, val articles: List<Articles>)

@Serializable
class Articles : RealmObject {
    var author: String? = null
    var title: String = ""
    var description: String? = null
    var urlToImage: String? = null
    var content: String? = null
}
