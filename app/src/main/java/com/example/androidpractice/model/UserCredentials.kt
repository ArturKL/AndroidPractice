package com.example.androidpractice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserCredentials(
    val email: String,
    val password: String
) : Parcelable