package com.muriloorias

import com.muriloorias.dto.NewsRequest
import com.muriloorias.dto.toTaskResponse
import com.muriloorias.repository.Repository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.util.UUID

fun Application.configureRouting() {
    val repository: Repository by inject()
    routing {
        get("news") {
            val response = repository.news().map {
                it.toTaskResponse()
            }
            call.respond(response)
        }
        post("news") {
            val request = call.receive<NewsRequest>()
            repository.save(request.toNewsModel())?.let {
                call.respondText("tarefa foi criada", status = HttpStatusCode.Created)
            } ?: call.respondText("não foi possivel criar a tarefa", status = HttpStatusCode.BadRequest)
        }
    }
}
