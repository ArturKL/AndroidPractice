package com.example.androidpractice.screen.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentLoginBinding

class LoginFragment: Fragment(R.layout.fragment_login) {

    private var viewBinding: FragmentLoginBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentLoginBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}