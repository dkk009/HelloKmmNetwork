package com.app.hellokmmnetwork.news.usecase

import com.app.hellokmmnetwork.news.data.repository.NewsFeedRepository

class NewsFeedUseCase(private val newsFeedRepository: NewsFeedRepository) {
    suspend fun invoke() = newsFeedRepository.fetchNews()
}