package com.example.androidpractice.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.androidpractice.databinding.ItemMainBinding
import com.example.androidpractice.model.ArticleModel

class MainViewHolder(
    private val viewBinding: ItemMainBinding,
    private val requestManager: RequestManager,
    private val onItemClickViewHolder: (Int) -> Unit,
    private val onImageClickViewHolder: (Int) -> Unit
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bindData(item: ArticleModel, itemPosition: Int) {
        with (viewBinding) {
            articleTitle.text = item.title
            articleDescription.text = item.description
            requestManager.load(item.imgUrl).into(articleIv)

            root.setOnClickListener {
                onItemClickViewHolder.invoke(itemPosition)
            }

            articleIv.setOnClickListener {
                onImageClickViewHolder.invoke(itemPosition)
            }
        }
    }
}