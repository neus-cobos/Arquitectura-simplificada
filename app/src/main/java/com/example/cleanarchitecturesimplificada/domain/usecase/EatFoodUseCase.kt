package com.example.cleanarchitecturesimplificada.domain.usecase

import com.example.cleanarchitecturesimplificada.domain.model.GameState
import com.example.cleanarchitecturesimplificada.domain.repository.GameRepository

class EatFoodUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(): GameState {

        val gameState = repository.getGameState()

        if (
            gameState.inventory.food <= 0 ||
            gameState.player.health >= 100
        ) {
            return gameState
        }

        val newInventory = gameState.inventory.copy(
            food = gameState.inventory.food - 1
        )

        val newPlayer = gameState.player.copy(
            health = (gameState.player.health + 20)
                .coerceAtMost(100)
        )

        val newGameState = gameState.copy(
            player = newPlayer,
            inventory = newInventory
        )

        repository.saveGameState(newGameState)

        return newGameState
    }
}