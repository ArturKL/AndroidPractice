package com.example.androidpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.androidpractice.databinding.ItemMainBinding
import com.example.androidpractice.model.ArticleModel
import com.example.androidpractice.viewholder.MainViewHolder

class MainAdapter(
    private val dataList: List<ArticleModel>,
    private val requestManager: RequestManager,
    private val onItemClickAdapter: (Int) -> Unit,
    private val onImageClickAdapter: (Int) -> Unit
) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val viewBinding = ItemMainBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(
            viewBinding = viewBinding,
            requestManager = requestManager,
            onItemClickViewHolder = onItemClickAdapter,
            onImageClickViewHolder = onImageClickAdapter
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(dataList[position], position)
    }

    override fun getItemCount(): Int = dataList.size

}