package com.example.androidpractice.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    private var viewBinding : FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}