package com.example.chapter_7_allminitask.koin.di

import com.example.chapter_7_allminitask.koin.ui.MainActivityViewModelKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModuleKoin = module {

    viewModel{
        MainActivityViewModelKoin(get())
    }

}