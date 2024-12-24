package com.muriloorias.dto

import com.muriloorias.model.NewsModel
import kotlinx.serialization.Serializable

@Serializable
class NewsRequest(
    val title: String,
    val text: String,
    val date: String
) {
    fun toNewsModel() = NewsModel(
        title = title,
        text = text,
        date = date
    )
}