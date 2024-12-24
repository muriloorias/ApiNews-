package com.muriloorias.repository

import com.muriloorias.database.dao.NewsDao
import com.muriloorias.model.NewsModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Repository: KoinComponent {
    private val dao: NewsDao by inject()

    suspend fun news() = dao.findAll()

    suspend fun save(news: NewsModel) = dao.save(news)

}