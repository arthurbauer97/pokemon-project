package com.example.pokemon_project.domain.pokemon.use_case

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.domain.info_pokemon.models.PokemonInfoData
import com.example.pokemon_project.domain.pokemon.models.PokemonData
import com.example.pokemon_project.domain.pokemon.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend fun fetchPokemonList(limit: Int, offset: Int): Flow<State<PokemonData>> {
        return pokemonRepository.fetchPokemonList(limit, offset)
    }
}