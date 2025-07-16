package com.example.androidpractice.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentMainBinding
import com.example.androidpractice.utils.ContentRepository
import kotlin.random.Random

class MainFragment: Fragment(R.layout.fragment_main) {

    private var viewBinding : FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainBinding.bind(view)
        initView()
    }

    private fun initView() {
        viewBinding?.apply {
            randomBtn.setOnClickListener {
                val index = Random.nextInt(10)
                val url = ContentRepository.getPictureList()[index]
                randomIv.let { img ->
                    Glide.with(this@MainFragment)
                        .load(url)
                        .into(img)
                }
            }

            nextPageBtn.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_mainFragment_to_loginFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}