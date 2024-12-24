package com.muriloorias.database.dao

import com.muriloorias.model.NewsModel
import com.muriloorias.model.NewsTable
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
class NewsDao {
    suspend fun findAll(): List<NewsModel> = dbQuery {
        NewsTable.selectAll().map{
            NewsModel(
                id = it[NewsTable.id],
                title  = it[NewsTable.title],
                text = it[NewsTable.text],
                date = it[NewsTable.date]
            )
        }
    }

    suspend fun save (newsModel: NewsModel) = dbQuery {
        NewsTable.insert {
            it[id] = newsModel.id
            it[title] = newsModel.title
            it[text] = newsModel.text
            it[date] = newsModel.date
        }
    }
}

suspend fun <T> dbQuery(block: suspend () -> T): T=
    newSuspendedTransaction(Dispatchers.IO) { block() }