package com.app.hellokmmnetwork.database

import com.app.hellokmmnetwork.news.data.entity.Articles
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.log.LogLevel

private val schema = setOf(Articles::class)
val configuration = RealmConfiguration.Builder(schema = schema).name("realm-local").schemaVersion(1)
    .log(LogLevel.ALL).build()

fun configureRealmDataBase(): Realm {
    return Realm.open(configuration = configuration)
}

