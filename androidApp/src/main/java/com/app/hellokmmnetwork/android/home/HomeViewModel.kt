package com.app.hellokmmnetwork.android.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.app.hellokmmnetwork.news.usecase.NewsFeedUseCase

class HomeViewModel(private val newsFeedUseCase: NewsFeedUseCase) : ViewModel() {
    init {
        Log.d("HomeViewModel", "Usecase:$newsFeedUseCase")
    }
}