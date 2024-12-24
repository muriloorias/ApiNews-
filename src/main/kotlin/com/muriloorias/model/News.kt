package com.muriloorias.model

import org.jetbrains.exposed.sql.Table
import java.util.UUID

data class NewsModel (
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val text: String,
    val date: String
)

object NewsTable: Table(){
    val id = uuid("id").autoGenerate()
    val title = text("title")
    val text  = text("text")
    val date = text("date")
}
