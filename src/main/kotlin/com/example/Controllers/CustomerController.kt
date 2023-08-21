package com.example.Controllers

import com.example.models.Customer
import com.example.models.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerController() {
    route("/customer") {
        /**
         * Get list of all the customers
         */
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(customerStorage)
            } else {
                call.respondText(text = "No customer found", status = HttpStatusCode.OK)
            }
        }
        /**
         * Get detail of specific customer
         */
        get("{id?}") {
            val id = call.parameters["id"]
            if (!id.isNullOrEmpty()) {
                val customer = customerStorage.find { it.id == id }
                if (customer != null) {
                    call.respond(customer)

                }
                call.respondText(text = "Customer with id $id does not exist", status = HttpStatusCode.NotFound)
            }
            call.respondText(text = "Missing Id parameter", status = HttpStatusCode.BadRequest)
        }
        /**
         * Create new customer
         */
        post {
            val customerObj = call.receive<Customer>()
            customerStorage.add(customerObj)
            call.respondText(text = "Customer successfully created", status = HttpStatusCode.Created)
        }
        /**
         * Delete customer data
         */
        delete("{id?}") {
            val id = call.parameters["id"]
            if (!id.isNullOrEmpty()) {
                if (customerStorage.removeIf { it.id == id }) {
                    call.respondText(text = "Customer with id $id is successfully removed", status = HttpStatusCode.OK)
                }
                call.respondText(text = "User with id $id does not exists", status = HttpStatusCode.NotFound)
            }
            call.respondText(text = "Invalid parameter `id`", status = HttpStatusCode.BadRequest)
        }
    }

}