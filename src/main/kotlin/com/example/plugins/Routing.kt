package com.example.plugins

import com.example.Controllers.customerController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerController()
    }
}
