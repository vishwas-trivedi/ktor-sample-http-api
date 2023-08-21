package com.example.Controllers

import com.example.models.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerController() {
    route("/customer") {
        /**
         * Get list of all the customers
         */
        get {
            if (customerStorage.isNotEmpty()){
                call.respond(customerStorage)
            }
            else{
                call.respondText(text="No customer found", status= HttpStatusCode.OK)
            }
        }
        /**
         * Get detail of specific customer
         */
        get("{id?}") {

        }
        /**
         * Create new customer
         */
        post {

        }
        /**
         * Delete customer data
         */
        delete("{id?}") {

        }
    }

}