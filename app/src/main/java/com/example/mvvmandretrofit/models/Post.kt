package com.example.mvvmandretrofit.models

import android.icu.text.CaseMap

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
