package com.example.mvvmandretrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmandretrofit.apis.PostService
import com.example.mvvmandretrofit.models.Post

class PostRepository(private val postService: PostService) {


    private val postLiveData = MutableLiveData<List<Post>>()

    val posts: LiveData<List<Post>>
    get() = postLiveData

    suspend fun getPosts(userId: Int){

        val result = postService.getPost(userId)

        if (result?.body() != null){
            postLiveData.postValue(result.body())
        }
    }


}