package com.example.pokemon_project.domain.pokemon.repositories

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.domain.pokemon.models.PokemonData
import com.example.pokemon_project.networking.pokemon.model.PokemonResponse
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun fetchPokemonList(
        limit: Int,
        offset: Int
    ): Flow<State<PokemonData>>
}