package com.example.Controllers

import io.ktor.server.routing.*

fun Route.customerController() {
    route("/customer") {
        /**
         * Get list of all the customers
         */
        get {

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