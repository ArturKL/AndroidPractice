package com.example.androidpractice.screen.main

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidpractice.R
import com.example.androidpractice.adapter.MainAdapter
import com.example.androidpractice.databinding.FragmentMainBinding
import com.example.androidpractice.model.ArticleModel
import com.example.androidpractice.utils.ContentRepository
import com.example.androidpractice.utils.Keys
import kotlin.random.Random

class MainFragment : Fragment(R.layout.fragment_main) {

    private var viewBinding: FragmentMainBinding? = null

    private var rvAdapter: MainAdapter? = null

    private var itemList: List<ArticleModel>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMainBinding.bind(view)
        initView()
    }

    private fun initView() {
        if (rvAdapter == null) {
            if (itemList == null) {
                itemList = ContentRepository.getArticleList(Random.nextInt(10, 30))
            }
            rvAdapter = MainAdapter(
                dataList = itemList ?: emptyList(),
                requestManager = Glide.with(this),
                onItemClickAdapter = ::onItemClick
            )
        }
        val layoutManger = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        viewBinding?.apply {
            mainRv.layoutManager = layoutManger
            mainRv.adapter = rvAdapter
        }
    }

    private fun onItemClick(position: Int) {
        val item = itemList?.get(position) ?: return
        val data = bundleOf(Keys.ARTICLE_KEY to item)

        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment, data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}