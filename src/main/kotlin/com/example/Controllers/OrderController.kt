package com.example.Controllers

import com.example.models.orderStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listOrderController(){
    /**
     * Get the list of al the orders
     */
    get("/order"){
        if (orderStorage.isNotEmpty())
        {
            call.respond(orderStorage)
        }
        call.respondText(text="No order found", status=HttpStatusCode.NotFound)
    }
}

fun Route.getOrderController(){
    get("/order/{id}"){
        val orderId = call.parameters["id"]
        if (orderId.isNullOrEmpty()){
            call.respondText(text="Invalid id parameter", status = HttpStatusCode.BadRequest)
        }

        val order = orderStorage.find { it.number == orderId}
        if (order == null)
            call.respondText(text="Order with id $orderId does not exists", status = HttpStatusCode.NotFound)
        else
            call.respond(order)
    }
}

fun Route.totalizeOrderController(){
    /**
     * Allows to fetch total price of any specific order
     */
    get("/order/{id?}/total"){
        val id = call.parameters["id"]
        if (id.isNullOrEmpty())
            call.respondText(text="Id can not be null or empty", status = HttpStatusCode.BadRequest)

        val order = orderStorage.find { it.number == id }
        if (order == null) {
            call.respondText(text = "Order with Id $id does not exist", status = HttpStatusCode.NotFound)
        }
        else {
            val total = order.contents.sumOf { it.price * it.amount }
            call.respond(total)
        }

    }
}