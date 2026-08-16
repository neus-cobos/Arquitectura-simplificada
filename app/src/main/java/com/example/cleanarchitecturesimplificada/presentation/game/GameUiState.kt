package com.example.cleanarchitecturesimplificada.presentation.game

data class GameUiState(
    val playerName: String = "",
    val health: Int = 0,
    val night: Int = 1,
    val fireLevel: Int = 0,
    val wood: Int = 0,
    val food: Int = 0,
    val gameOver: Boolean = false
)