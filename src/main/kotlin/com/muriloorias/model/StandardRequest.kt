package com.muriloorias.model

import kotlinx.serialization.Serializable

@Serializable
data class StandardRequest(
    val title: String ,
    val text: String,
    val date: String
)