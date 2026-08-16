package com.example.cleanarchitecturesimplificada.domain.model

data class GameState(
    val player: Player,
    val camp: Camp,
    val inventory: Inventory
)