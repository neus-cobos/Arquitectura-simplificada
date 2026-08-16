package com.example.cleanarchitecturesimplificada.domain.repository

import com.example.cleanarchitecturesimplificada.domain.model.GameState

//esto es un contrato, domain sabrá qué necesita, pero no cómo lo va a hacer
interface GameRepository {

    fun getGameState(): GameState

    fun saveGameState(gameState: GameState)
}