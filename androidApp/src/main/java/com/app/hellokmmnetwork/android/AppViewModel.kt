package com.app.hellokmmnetwork.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.hellokmmnetwork.network.AppRequest
import com.app.hellokmmnetwork.news.data.entity.Articles
import com.app.hellokmmnetwork.news.usecase.NewsFeedUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

sealed class NewsFeedState {
    object None : NewsFeedState()
    object Loading : NewsFeedState()
    data class Error(val error: String) : NewsFeedState()
    data class Success(val data: List<Articles>) : NewsFeedState()

}

class AppViewModel(private val newsFeedUseCase: NewsFeedUseCase) : ViewModel() {
    var newsFeedState: MutableStateFlow<NewsFeedState> =
        MutableStateFlow(NewsFeedState.None)
        private set
    var selectedArticle: MutableStateFlow<Articles?> = MutableStateFlow(null)
        private set

    init {
        getNewsFeed()
    }

    private fun getNewsFeed() {
        viewModelScope.launch {
            newsFeedState.value = NewsFeedState.Loading
            when (val data = newsFeedUseCase.invoke()) {
                is AppRequest.Result<*> -> {
                    (data.result as List<Articles>).run {
                        newsFeedState.value = NewsFeedState.Success(this)
                    }
                }
                is AppRequest.Error -> {
                    newsFeedState.value =
                        NewsFeedState.Error(data.error.message ?: "Something went wrong")
                }
                is AppRequest.Loading -> {
                    newsFeedState.value = NewsFeedState.Loading
                }
            }
        }
    }

    fun setUserSelectedArticle(articles: Articles) {
        selectedArticle.value = articles
    }
}