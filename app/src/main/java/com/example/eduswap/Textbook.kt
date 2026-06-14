package com.example.eduswap

import android.net.Uri

data class Textbook(
    val title: String,
    val author: String,
    val edition: String,
    val description: String,
    val price: String,
    val seller: String,
    val university: String,
    val condition: String,
    val image1: Uri? = null,
    val image2: Uri? = null,
    val image3: Uri? = null
)