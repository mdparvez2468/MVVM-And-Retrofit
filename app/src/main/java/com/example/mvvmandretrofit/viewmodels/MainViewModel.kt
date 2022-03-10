package com.example.mvvmandretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmandretrofit.models.Post
import com.example.mvvmandretrofit.repository.PostRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PostRepository): ViewModel() {

    init {
        GlobalScope.launch {
            repository.getPosts(1)
        }

    }

    val posts: LiveData<List<Post>>
    get() = repository.posts
}