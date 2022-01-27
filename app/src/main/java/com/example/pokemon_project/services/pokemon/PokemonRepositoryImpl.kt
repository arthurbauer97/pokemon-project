package com.example.pokemon_project.services.pokemon

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.domain.info_pokemon.models.PokemonInfoData
import com.example.pokemon_project.domain.pokemon.models.PokemonData
import com.example.pokemon_project.domain.pokemon.repositories.PokemonRepository
import com.example.pokemon_project.networking.info_pokemon.model.toDomain
import com.example.pokemon_project.networking.pokemon.PokemonNetwork
import com.example.pokemon_project.networking.pokemon.model.PokemonResponse
import com.example.pokemon_project.networking.pokemon.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class PokemonRepositoryImpl(
    private val service: PokemonNetwork
): PokemonRepository {
    override suspend fun fetchPokemonList(limit: Int, offset: Int): Flow<State<PokemonData>> {
        val mutableSharedFlow = MutableSharedFlow<State<PokemonData>>(replay = 1)
        var requestRes = service.getPokemons(limit,offset)

        if (requestRes is State.Success) {
            mutableSharedFlow.emit(State.Success(requestRes.data.toDomain()))
        } else {
            mutableSharedFlow.emit(State.Failure("Deu ruim"))
        }
        return mutableSharedFlow
    }
}