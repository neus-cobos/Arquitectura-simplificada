package com.example.cleanarchitecturesimplificada.di

import com.example.cleanarchitecturesimplificada.data.repository.FakeGameRepository
import com.example.cleanarchitecturesimplificada.domain.usecase.AddWoodToFireUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.CollectWoodUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.EatFoodUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.GetGameStateUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.NextNightUseCase

object AppContainer {

    val gameRepository = FakeGameRepository()

    val getGameStateUseCase =
        GetGameStateUseCase(gameRepository)

    val collectWoodUseCase =
        CollectWoodUseCase(gameRepository)

    val addWoodToFireUseCase =
        AddWoodToFireUseCase(gameRepository)

    val eatFoodUseCase =
        EatFoodUseCase(gameRepository)

    val nextNightUseCase =
        NextNightUseCase(gameRepository)
}