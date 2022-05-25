package com.example.chapter_7_allminitask.koin.data

import com.example.chapter_7_allminitask.koin.data.service.ApiHelperKoin

class RepositoryKoin(private val apiHelperKoin: ApiHelperKoin) {
    suspend fun getPosts() = apiHelperKoin.getAllPosts()
}