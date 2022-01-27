package com.example.pokemon_project.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon_project.commons.State
import com.example.pokemon_project.commons.ui.ViewState
import com.example.pokemon_project.domain.info_pokemon.models.PokemonInfoData
import com.example.pokemon_project.domain.info_pokemon.use_case.GetPokemonInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PokemonInfoViewModel(
    private val dispatcher: CoroutineContext,
    private val pokemonInfoUseCase: GetPokemonInfoUseCase
): ViewModel() {

    private val _pokemonInfoResponse = MutableStateFlow<ViewState<PokemonInfoData>>(ViewState.Loading)
    val pokemonInfoResponse get() = _pokemonInfoResponse.asStateFlow()

    fun fetchPokemonInfo(name: String){
        viewModelScope.launch(dispatcher){
            _pokemonInfoResponse.emit(ViewState.Loading)

            pokemonInfoUseCase.fetchPokemonInfo(name).collect { state ->
                when(state){
                    is State.Success -> {
                        _pokemonInfoResponse.emit(ViewState.Success(state.data))
                    }
                    is State.Failure -> {
                        _pokemonInfoResponse.emit(ViewState.Failure("pau no viewmodel"))
                    }
                }
            }
        }
    }

}