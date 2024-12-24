package com.muriloorias.dto

import com.muriloorias.model.NewsModel
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse (
    val id: String,
    val title: String,
    val text: String,
    val date: String
)

fun NewsModel.toTaskResponse() = NewsResponse(
    id = id.toString(),
    title = title,
    text = text,
    date = date
)