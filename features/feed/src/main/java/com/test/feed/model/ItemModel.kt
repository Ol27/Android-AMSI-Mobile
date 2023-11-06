package com.test.feed.model

sealed class ItemModel {

    data class Header(
        val title: String,
        val subtitle: String,
        val image: String,
    ) : ItemModel()

    data class TitleJob(
        val text: String,
    )

    data class TitleEvents(
        val text: String,
    )
}