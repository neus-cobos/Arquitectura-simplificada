package com.example.cleanarchitecturesimplificada.domain.usecase

import com.example.cleanarchitecturesimplificada.domain.model.GameState
import com.example.cleanarchitecturesimplificada.domain.repository.GameRepository

class GetGameStateUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(): GameState {
        return repository.getGameState()
    }
}