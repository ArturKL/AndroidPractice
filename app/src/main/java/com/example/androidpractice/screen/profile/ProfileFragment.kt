package com.example.androidpractice.screen.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentProfileBinding
import com.example.androidpractice.model.UserCredentials
import com.example.androidpractice.utils.Keys
import com.example.androidpractice.utils.getParcelable

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private var viewBinding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentProfileBinding.bind(view)
        initView()
    }

    private fun initView() {
        viewBinding?.apply {
            val credentials = getParcelable<UserCredentials>(Keys.CREDENTIALS_KEY) ?: return
            emailTv.text = "${getString(R.string.email_tv_text)} ${credentials.email}"
            passwordTv.text = "${getString(R.string.password_tv_text)} ${credentials.password}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}