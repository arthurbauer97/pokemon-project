package com.example.pokemon_project.domain.info_pokemon.repositories

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.domain.info_pokemon.models.PokemonInfoData
import kotlinx.coroutines.flow.Flow

interface PokemonInfoRepository {

    suspend fun fetchPokemonInfo(
        name: String
    ): Flow<State<PokemonInfoData>>
}