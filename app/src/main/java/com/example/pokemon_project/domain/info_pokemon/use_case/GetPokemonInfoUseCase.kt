package com.example.pokemon_project.domain.info_pokemon.use_case

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.domain.info_pokemon.models.PokemonInfoData
import com.example.pokemon_project.domain.info_pokemon.repositories.PokemonInfoRepository
import com.example.pokemon_project.domain.pokemon.models.PokemonData
import com.example.pokemon_project.domain.pokemon.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonInfoUseCase(
    private val pokemonInfoRepository: PokemonInfoRepository
) {

    suspend fun fetchPokemonInfo(name: String): Flow<State<PokemonInfoData>> {
        return pokemonInfoRepository.fetchPokemonInfo(name)
    }

}