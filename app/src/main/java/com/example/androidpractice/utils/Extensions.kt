package com.example.androidpractice.utils

import android.os.Build
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.example.androidpractice.model.UserCredentials

inline fun <reified T : Parcelable?> Fragment.getParcelable(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arguments?.getParcelable(key, T::class.java)
    } else {
        arguments?.getParcelable<T>(key)
    }
}