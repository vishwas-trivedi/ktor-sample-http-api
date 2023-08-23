package com.example.models

import kotlinx.serialization.Serializable

/**
 * Data model containing Order details
 */
@Serializable
data class Order(val number: String, val contents : List<OrderItem>)

/**
 * Data model containing order item details
 */
@Serializable
data class OrderItem(val item: String, val amount: Int, val price: Double)

/**
 * In-memory storage for order details
 */


val orderStorage = listOf<Order>(Order(
    "2020-04-06-01", listOf(
        OrderItem("Cheesecake",2,5.50),
        OrderItem("Water",1,1.75),
        OrderItem("Beer",1,3.50))),
    Order("2020-04-06-02", listOf(
        OrderItem("Water",2,2.25),
        OrderItem("Cheesecake",1,5.50),
        OrderItem("Ice Cream",1,3.75)
    ))
)