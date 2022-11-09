package com.app.hellokmmnetwork.di

import com.app.hellokmmnetwork.database.configureRealmDataBase
import com.app.hellokmmnetwork.network.createHttpClient
import com.app.hellokmmnetwork.network.createJson
import com.app.hellokmmnetwork.news.data.datasource.RemoteNewsDataSource
import com.app.hellokmmnetwork.news.data.datasource.RemoteNewsDataSourceImpl
import com.app.hellokmmnetwork.news.data.repository.NewsFeedRepository
import com.app.hellokmmnetwork.news.data.repository.NewsFeedRepositoryImpl
import com.app.hellokmmnetwork.news.usecase.NewsFeedUseCase
import com.app.hellokmmnetwork.platformModule
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import kotlin.reflect.KClass

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, platformModule())
}

fun initKoin() = initKoin {  }
val commonModule = module {
    single { createJson() }
    single { createHttpClient(get()) }
    single { configureRealmDataBase() }
    factory<RemoteNewsDataSource> { RemoteNewsDataSourceImpl(get()) }
    factory<NewsFeedRepository> { NewsFeedRepositoryImpl(get(), get()) }
    factory { NewsFeedUseCase(get()) }
}

fun <T> Koin.provideDependency(clazz: KClass<*>): T {
    return get(clazz, null)
}