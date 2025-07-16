package com.example.androidpractice.screen.login

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentLoginBinding
import com.example.androidpractice.model.UserCredentials
import com.example.androidpractice.utils.Keys
import java.util.regex.Pattern

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var viewBinding: FragmentLoginBinding? = null

    private var validEmail = false
    private var validPassword = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentLoginBinding.bind(view)
        initView()
    }

    private fun initView() {
        viewBinding?.apply {
            emailEt.doOnTextChanged { text, _, _, _ ->
                val input = text ?: ""
                validEmail = Patterns.EMAIL_ADDRESS.matcher(input).matches()
                tryEnableLoginBtn()
            }

            passwordEt.doOnTextChanged { text, _, _, _ ->
                val input = text ?: ""
                validPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,}\$"
                    .toRegex()
                    .matches(input)
                tryEnableLoginBtn()
            }

            loginBtn.setOnClickListener {
                viewBinding?.apply {
                    val data = Bundle()
                    data.putParcelable(
                        Keys.CREDENTIALS_KEY,
                        UserCredentials(emailEt.text.toString(), passwordEt.text.toString())
                    )

                    findNavController().navigate(R.id.action_loginFragment_to_profileFragment, data)
                }
            }
        }
    }

    private fun tryEnableLoginBtn() {
        viewBinding?.loginBtn?.isEnabled = validEmail && validPassword
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}