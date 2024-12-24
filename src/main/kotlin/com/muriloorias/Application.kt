package com.muriloorias

import com.muriloorias.database.DataBaseFactory
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DataBaseFactory.initDB()
    install(ContentNegotiation){
        json(
            Json {
                ignoreUnknownKeys = true
            }
        )
    }
    configureFrameworks()
    configureRouting()
}
