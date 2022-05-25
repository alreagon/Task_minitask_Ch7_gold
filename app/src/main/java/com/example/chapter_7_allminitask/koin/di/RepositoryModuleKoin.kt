package com.example.chapter_7_allminitask.koin.di

import com.example.chapter_7_allminitask.koin.data.RepositoryKoin
import org.koin.dsl.module

val repositoryModuleKoin = module{

    single {
        RepositoryKoin(get())
    }
}