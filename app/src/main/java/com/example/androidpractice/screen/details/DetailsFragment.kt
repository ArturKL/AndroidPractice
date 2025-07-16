package com.example.androidpractice.screen.details

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.androidpractice.R
import com.example.androidpractice.databinding.FragmentDetailsBinding
import com.example.androidpractice.model.ArticleModel
import com.example.androidpractice.utils.Keys
import com.example.androidpractice.utils.getParcelable

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var viewBinding: FragmentDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentDetailsBinding.bind(view)
        initView()
    }

    private fun initView() {
        var item = getParcelable<ArticleModel>(Keys.ARTICLE_KEY) ?: return
        viewBinding?.apply {
            Glide.with(this@DetailsFragment).load(item.imgUrl).into(detailsIv)
            detailsTitle.text = item.title
            detailsDescription.text = item.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}