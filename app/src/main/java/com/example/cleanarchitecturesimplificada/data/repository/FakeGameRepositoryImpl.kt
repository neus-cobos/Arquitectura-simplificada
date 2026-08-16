package com.example.cleanarchitecturesimplificada.data.repository

import com.example.cleanarchitecturesimplificada.domain.model.Camp
import com.example.cleanarchitecturesimplificada.domain.model.GameState
import com.example.cleanarchitecturesimplificada.domain.model.Inventory
import com.example.cleanarchitecturesimplificada.domain.model.Player
import com.example.cleanarchitecturesimplificada.domain.repository.GameRepository

class FakeGameRepository : GameRepository {

    private var gameState = GameState(
        player = Player(
            name = "Player 1",
            health = 100
        ),
        camp = Camp(
            night = 1,
            fireLevel = 50
        ),
        inventory = Inventory(
            wood = 0,
            food = 2
        )
    )

    override fun getGameState(): GameState {
        return gameState
    }

    override fun saveGameState(gameState: GameState) {
        this.gameState = gameState
    }
}