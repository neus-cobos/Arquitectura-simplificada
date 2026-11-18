package com.example.cleanarchitecturesimplificada.domain.model

data class Player(
    val name: String,
    val health: Int
){
    val isAlive: Boolean
        get() = health > 0
}
