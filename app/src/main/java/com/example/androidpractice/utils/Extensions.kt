package com.example.androidpractice.utils

import android.os.Build
import androidx.fragment.app.Fragment
import com.example.androidpractice.model.UserCredentials

inline fun <reified T> Fragment.getParcelable(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arguments?.getParcelable(Keys.CREDENTIALS_KEY, T::class.java)
    } else {
        arguments?.getParcelable<UserCredentials>(Keys.CREDENTIALS_KEY) as? T
    }
}