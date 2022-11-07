package com.app.hellokmmnetwork.android.di

import com.app.hellokmmnetwork.android.AppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AppViewModel(get())
    }

}