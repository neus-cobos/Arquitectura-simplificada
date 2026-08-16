package com.example.cleanarchitecturesimplificada.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturesimplificada.databinding.ActivityMainBinding
import com.example.cleanarchitecturesimplificada.presentation.game.GameViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: GameViewModel by viewModels {
        GameViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        observeUiState()

        setupListeners()
    }

    private fun setupListeners() {

        binding.btnCollectWood.setOnClickListener {
            viewModel.onCollectWood()
        }

        binding.btnAddWoodToFire.setOnClickListener {
            viewModel.onAddWoodToFire()
        }

        binding.btnEat.setOnClickListener {
            viewModel.onEatFood()
        }

        binding.btnNextNight.setOnClickListener {
            viewModel.onNextNight()
        }
    }

    private fun observeUiState() {

        viewModel.uiState.observe(this) { state ->

            binding.tvPlayer.text =
                "Jugador: ${state.playerName}"

            binding.tvHealth.text =
                "Vida: ${state.health}"

            binding.tvNight.text =
                "Noche: ${state.night}"

            binding.tvFire.text =
                "Fuego: ${state.fireLevel}"

            binding.tvWood.text =
                "Madera: ${state.wood}"

            binding.tvFood.text =
                "Comida: ${state.food}"

            binding.tvGameOver.visibility =
                if (state.gameOver) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
        }
    }
}