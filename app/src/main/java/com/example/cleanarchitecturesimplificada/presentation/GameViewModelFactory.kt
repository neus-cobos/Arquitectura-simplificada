package com.example.cleanarchitecturesimplificada.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturesimplificada.data.repository.FakeGameRepository
import com.example.cleanarchitecturesimplificada.domain.usecase.AddWoodToFireUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.CollectWoodUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.EatFoodUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.GetGameStateUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.NextNightUseCase
import com.example.cleanarchitecturesimplificada.presentation.game.GameViewModel

class GameViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        val repository = FakeGameRepository()

        val getGameState =
            GetGameStateUseCase(repository)

        val collectWood =
            CollectWoodUseCase(repository)

        val addWoodToFire =
            AddWoodToFireUseCase(repository)

        val eatFood =
            EatFoodUseCase(repository)

        val nextNight =
            NextNightUseCase(repository)

        @Suppress("UNCHECKED_CAST")
        return GameViewModel(
            getGameState,
            collectWood,
            addWoodToFire,
            eatFood,
            nextNight
        ) as T
    }
}