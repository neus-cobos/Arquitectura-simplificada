package com.example.cleanarchitecturesimplificada.domain.usecase

import com.example.cleanarchitecturesimplificada.domain.model.GameState
import com.example.cleanarchitecturesimplificada.domain.repository.GameRepository

class NextNightUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(): GameState {

        val gameState = repository.getGameState()

        val newFireLevel =
            (gameState.camp.fireLevel - 20)
                .coerceAtLeast(0)

        val newHealth =
            if (newFireLevel == 0) {
                (gameState.player.health - 25)
                    .coerceAtLeast(0)
            } else {
                gameState.player.health
            }

        val newCamp = gameState.camp.copy(
            night = gameState.camp.night + 1,
            fireLevel = newFireLevel
        )

        val newPlayer = gameState.player.copy(
            health = newHealth
        )

        val newGameState = gameState.copy(
            camp = newCamp,
            player = newPlayer
        )

        repository.saveGameState(newGameState)

        return newGameState
    }
}