package com.example.plugins

import com.example.Controllers.customerController
import com.example.Controllers.getOrderController
import com.example.Controllers.listOrderController
import com.example.Controllers.totalizeOrderController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerController()
        listOrderController()
        getOrderController()
        totalizeOrderController()
    }
}
