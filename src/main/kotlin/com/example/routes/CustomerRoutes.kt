package com.example.routes

import com.example.models.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRoutong() {
    route("/customer") {
        get {
            if (customerStorage.isNotEmpty())
            {
                call.respond(customerStorage);
            }
            else
            {
                call.respondText(text = "Customer not found",
                    status = HttpStatusCode.NotFound)
            }

        }
        get("{id?}") {

        }
        post {

        }
        delete("{id?}") {

        }
    }

}