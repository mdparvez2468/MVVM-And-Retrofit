package com.example.mvvmandretrofit.apis

import com.example.mvvmandretrofit.models.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {

    @GET("posts")
    suspend fun getPost(@Query("userId") userId: Int): Response<List<Post>>


}