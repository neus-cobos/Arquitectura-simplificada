package com.example.cleanarchitecturesimplificada.domain.usecase

import com.example.cleanarchitecturesimplificada.domain.model.GameState
import com.example.cleanarchitecturesimplificada.domain.repository.GameRepository

class CollectWoodUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(): GameState {

        val gameState = repository.getGameState()

        val newInventory = gameState.inventory.copy(
            wood = gameState.inventory.wood + 1
        )

        val newGameState = gameState.copy(
            inventory = newInventory
        )

        repository.saveGameState(newGameState)

        return newGameState
    }
}