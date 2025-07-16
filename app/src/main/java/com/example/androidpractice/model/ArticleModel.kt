package com.example.androidpractice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleModel(
    val imgUrl: String,
    val title: String,
    val description: String
) : Parcelable {
    override fun toString(): String {
        return "Title: $title; Desc: $description"
    }
}