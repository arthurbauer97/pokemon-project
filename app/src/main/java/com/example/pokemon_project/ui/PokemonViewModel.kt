package com.example.pokemon_project.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon_project.commons.State
import com.example.pokemon_project.commons.ui.ViewState
import com.example.pokemon_project.domain.pokemon.models.PokemonData
import com.example.pokemon_project.domain.pokemon.use_case.GetPokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PokemonViewModel(
    private val dispatcher: CoroutineContext,
    private val pokemonUseCase: GetPokemonUseCase
) : ViewModel() {
    private val _pokemonResponse =
        MutableStateFlow<ViewState<PokemonData>>(ViewState.Loading)
    val pokemonResponse get() = _pokemonResponse.asStateFlow()

    fun fetchPokemon(limit: Int, offset: Int) {
        viewModelScope.launch(dispatcher) {
            _pokemonResponse.emit(ViewState.Loading)

            pokemonUseCase.fetchPokemonList(limit, offset).collect { state ->
                when (state) {
                    is State.Success -> {
                        _pokemonResponse.emit(ViewState.Success(state.data))
                    }
                    is State.Failure -> {
                        _pokemonResponse.emit(ViewState.Failure("pau no viewmodel"))
                    }
                }
            }
        }
    }
}