package com.muriloorias

import com.muriloorias.database.DataBaseFactory
import com.muriloorias.database.dao.NewsDao
import com.muriloorias.repository.Repository
import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureFrameworks() {
    install(Koin) {
        slf4jLogger()
        modules(modules)
    }
}

val modules = module {
    single { NewsDao() }
    single { Repository() }
}
