package com.example.cleanarchitecturesimplificada.domain.usecase

import com.example.cleanarchitecturesimplificada.domain.model.GameState
import com.example.cleanarchitecturesimplificada.domain.repository.GameRepository

class AddWoodToFireUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(): GameState {

        val gameState = repository.getGameState()

        if (gameState.inventory.wood <= 0) {
            return gameState
        }

        val newInventory = gameState.inventory.copy(
            wood = gameState.inventory.wood - 1
        )

        val newCamp = gameState.camp.copy(
            fireLevel = (gameState.camp.fireLevel + 15)
                .coerceAtMost(100)
        )

        val newGameState = gameState.copy(
            inventory = newInventory,
            camp = newCamp
        )

        repository.saveGameState(newGameState)

        return newGameState
    }
}