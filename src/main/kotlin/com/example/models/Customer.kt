package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(val id: String, val firstName: String,
                    val lastName:String, val email: String);

// Creating a temporary in-memory storage
val customerStorage = mutableListOf<Customer>();