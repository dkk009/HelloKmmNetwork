package com.app.hellokmmnetwork.android.di

import com.app.hellokmmnetwork.android.MainViewModel
import com.app.hellokmmnetwork.android.home.AppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel()
    }
    viewModel {
        AppViewModel(get())
    }

}