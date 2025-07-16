package com.example.androidpractice.utils

import com.example.androidpractice.model.ArticleModel
import kotlin.random.Random

object ContentRepository {

    fun getPictureList(): List<String> {
        return listOf(
            "https://i.pinimg.com/736x/6c/97/6a/6c976a7c5575520057b4c106d0276ca9.jpg",
            "https://i.pinimg.com/1200x/6d/1f/20/6d1f20401640b01051f28f5e20e54d2d.jpg",
            "https://i.pinimg.com/736x/70/b2/04/70b2041106946123053ad8f7a6a377c7.jpg",
            "https://i.pinimg.com/736x/62/36/b6/6236b653c4d81bfcda34e7472d5f1b46.jpg",
            "https://i.pinimg.com/736x/52/5a/66/525a66b59480e284eb727650f4ee42f2.jpg",
            "https://i.pinimg.com/736x/f8/0c/6e/f80c6e3145e8b7bb7efe5d1d5406acf9.jpg",
            "https://i.pinimg.com/1200x/8e/e2/93/8ee2937e58c6370621210788aba17273.jpg",
            "https://i.pinimg.com/736x/60/d3/8f/60d38f15a1778d6276243a6c389701ac.jpg",
            "https://i.pinimg.com/736x/c1/62/dd/c162ddbe43039b90466fefd4690061a1.jpg",
            "https://i.pinimg.com/736x/af/04/df/af04df0c02bc20c0a4df55a94c376b8a.jpg",
        )
    }

    fun getArticleList(itemCount: Int): List<ArticleModel> {
        val images = getPictureList()
        val titles = List(itemCount) { index -> "Cat number ${index + 1}"}.shuffled()
        val descriptionWords = listOf(
            "Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Consectetur",
            "Adipiscing", "Elit", "Sed", "Do", "Eiusmod", "Tempor",
            "Incididunt", "Labore", "Et", "Dolore", "Magna", "Aliqua",
            "Ut", "Enim", "Ad", "Minim", "Veniam", "Quis", "Nostrud",
            "Exercitation", "Ullamco", "Laboris", "Nisi", "Aliquip",
            "Ex", "Ea", "Commodo", "Consequat", "Duis", "Aute", "Irure"
        )

        return List(itemCount) { index ->
            ArticleModel(
                imgUrl = images.random(),
                title = titles[index],
                description = (1..20)
                    .joinToString(" ") { descriptionWords.random() }
            )
        }
    }
}