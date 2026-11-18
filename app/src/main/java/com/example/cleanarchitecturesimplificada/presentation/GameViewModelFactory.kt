package com.example.cleanarchitecturesimplificada.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturesimplificada.di.AppContainer
import com.example.cleanarchitecturesimplificada.presentation.game.GameViewModel

class GameViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        @Suppress("UNCHECKED_CAST")
        return GameViewModel(
            AppContainer.getGameStateUseCase,
            AppContainer.collectWoodUseCase,
            AppContainer.addWoodToFireUseCase,
            AppContainer.eatFoodUseCase,
            AppContainer.nextNightUseCase
        ) as T
    }
}