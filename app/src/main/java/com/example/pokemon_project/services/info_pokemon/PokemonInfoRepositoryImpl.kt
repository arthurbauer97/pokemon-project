package com.example.pokemon_project.services.info_pokemon

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.domain.info_pokemon.models.PokemonInfoData
import com.example.pokemon_project.domain.info_pokemon.repositories.PokemonInfoRepository
import com.example.pokemon_project.networking.info_pokemon.PokemonInfoNetwork
import com.example.pokemon_project.networking.info_pokemon.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class PokemonInfoRepositoryImpl(
    private val service: PokemonInfoNetwork
) : PokemonInfoRepository {
    override suspend fun fetchPokemonInfo(name: String): Flow<State<PokemonInfoData>> {
        val mutableSharedFlow = MutableSharedFlow<State<PokemonInfoData>>(replay = 1)
        var requestRes = service.getPokemon(name)

        if (requestRes is State.Success) {
            mutableSharedFlow.emit(State.Success(requestRes.data.toDomain()))
        } else {
            mutableSharedFlow.emit(State.Failure("Deu ruim"))
        }
        return mutableSharedFlow
    }
}