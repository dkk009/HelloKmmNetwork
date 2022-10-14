package com.app.hellokmmnetwork.android.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

class HomeViewModel(private val newsFeedUseCase: NewsFeedUseCase) : ViewModel() {
    var newsFeedState: MutableStateFlow<NewsFeedState> =
        MutableStateFlow(NewsFeedState.None)
        private set

    init {
        Log.d("HomeViewModel", "Usecase:$newsFeedUseCase")
        getNewsFeed()
    }

    fun getNewsFeed() {
        viewModelScope.launch {
            newsFeedState.value = NewsFeedState.Loading
            newsFeedUseCase.invoke().onFailure {
                Log.d("HomeViewModel", "NewsFeed:$it")
                newsFeedState.value = NewsFeedState.Error(it.message ?: "Something went wrong")
            }.onSuccess {
                newsFeedState.value = NewsFeedState.Success(it)
                Log.d("HomeViewModel", "NewsFeed:$it")
            }
        }
    }
}