package com.example.chapter_7_allminitask.koin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chapter_7_allminitask.koin.data.RepositoryKoin
import com.example.chapter_7_allminitask.koin.data.ResourceKoin
import com.example.chapter_7_allminitask.koin.data.model.GetAllPostsResponseItemKoin
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModelKoin(private val repositoryKoin: RepositoryKoin) : ViewModel() {
    //gk perlu lagi viewmodelfactory karena di ViewModelModuleKoin nya udh ke provide sama koinnya

    private val _posts = MutableLiveData<ResourceKoin<List<GetAllPostsResponseItemKoin>>>()
    val posts: LiveData<ResourceKoin<List<GetAllPostsResponseItemKoin>>>
        get() = _posts

    fun getAllPosts(){
        viewModelScope.launch {
            _posts.postValue(ResourceKoin.loading())
            try {
                _posts.postValue(ResourceKoin.success(repositoryKoin.getPosts()))
            }catch (exception: Exception){
                _posts.postValue(ResourceKoin.error(exception.message ?: "Error Occurred"))
            }
        }
    }
}