package com.example.chapter_7_allminitask.koin.data.model

import com.google.gson.annotations.SerializedName


data class GetAllPostsResponseItemKoin(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)