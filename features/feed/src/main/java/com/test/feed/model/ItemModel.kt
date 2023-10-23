package com.test.feed.model

sealed class ItemModel {

    data class Header(
        val title: String,
        val subtitle: String,
        val image: String,
    ) : ItemModel()

    data class Events(
        val title: String,
        val image: String,
        val date: String,
        val location: String,
        val time: String,
    ) : ItemModel()

    data class Job(
        val title: String,
        val image: String,
        val company: String,
        val location: String,
        val time: String,
        val tags: List<Tag>,
    ) : ItemModel() {

        data class Tag(
            val title: String,
            val color: String,
        )

    }

    data class TitleJob(
        val text: String,
    )

    data class TitleEvents(
        val text: String,
    )

}