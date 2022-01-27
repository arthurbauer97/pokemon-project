package com.example.pokemon_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.pokemon_project.commons.ui.ViewState
import com.example.pokemon_project.ui.PokemonInfoViewModel
import com.example.pokemon_project.ui.PokemonViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val pokemonViewModel: PokemonViewModel by viewModel()
    private val pokemonInfoViewModel: PokemonInfoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        pokemonViewModel.fetchPokemon(20,0)
        pokemonInfoViewModel.fetchPokemonInfo("pikachu")
        renderPokemon()
        renderPokemonInfo()
    }

    private fun renderPokemon() {
        lifecycleScope.launch {
            pokemonViewModel.pokemonResponse.collect { state ->
                when (state) {
                    is ViewState.Loading -> {
                        "carregando"
                    }
                    is ViewState.Failure -> {
                        "deu ruim"
                    }
                    is ViewState.Success -> {
                        state.data
                    }
                }
            }
        }
    }

    private fun renderPokemonInfo() {
        lifecycleScope.launch {
            pokemonInfoViewModel.pokemonInfoResponse.collect { state ->
                when (state) {
                    is ViewState.Loading -> {
                        "carregando"
                    }
                    is ViewState.Failure -> {
                        "deu ruim"
                    }
                    is ViewState.Success -> {
                        state.data
                    }
                }
            }
        }
    }
}