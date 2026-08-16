package com.example.cleanarchitecturesimplificada.presentation.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturesimplificada.domain.model.GameState
import com.example.cleanarchitecturesimplificada.domain.usecase.AddWoodToFireUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.CollectWoodUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.EatFoodUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.GetGameStateUseCase
import com.example.cleanarchitecturesimplificada.domain.usecase.NextNightUseCase

class GameViewModel(
    private val getGameState: GetGameStateUseCase,
    private val collectWood: CollectWoodUseCase,
    private val addWoodToFire: AddWoodToFireUseCase,
    private val eatFood: EatFoodUseCase,
    private val nextNight: NextNightUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<GameUiState>()

    val uiState: LiveData<GameUiState>
        get() = _uiState

    init {
        updateUi(getGameState())
    }

    fun onCollectWood() {
        updateUi(
            collectWood()
        )
    }

    fun onAddWoodToFire() {
        updateUi(
            addWoodToFire()
        )
    }

    fun onEatFood() {
        updateUi(
            eatFood()
        )
    }

    fun onNextNight() {
        updateUi(
            nextNight()
        )
    }

    private fun updateUi(gameState: GameState) {

        _uiState.value = GameUiState(
            playerName = gameState.player.name,
            health = gameState.player.health,
            night = gameState.camp.night,
            fireLevel = gameState.camp.fireLevel,
            wood = gameState.inventory.wood,
            food = gameState.inventory.food,
            gameOver = gameState.player.health <= 0
        )
    }
}