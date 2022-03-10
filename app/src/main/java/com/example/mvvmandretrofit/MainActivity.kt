package com.example.mvvmandretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmandretrofit.apis.PostService
import com.example.mvvmandretrofit.apis.RetrofitHelper
import com.example.mvvmandretrofit.models.Post
import com.example.mvvmandretrofit.repository.PostRepository
import com.example.mvvmandretrofit.viewmodels.MainViewModel
import com.example.mvvmandretrofit.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private val textView: TextView
    get() = findViewById(R.id.t)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postService = RetrofitHelper.getInstance().create(PostService::class.java)
        val repository = PostRepository(postService)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)


        mainViewModel.posts.observe(this, Observer {
            for (post in it){
                textView.append("Id: "+post.id+"\nTitle: "+post.title+"\n\n")
            }

        })



    }
}