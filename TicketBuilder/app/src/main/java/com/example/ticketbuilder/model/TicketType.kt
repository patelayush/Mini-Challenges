package com.example.ticketbuilder.model

data class TicketType (
    val type:String,
    val price: Int
)

val ticketTypes = listOf(
    TicketType("Standard",40),
    TicketType("VIP", 70),
    TicketType("Backstage", 120)
)