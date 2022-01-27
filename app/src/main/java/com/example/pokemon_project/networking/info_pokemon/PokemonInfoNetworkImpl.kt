package com.example.pokemon_project.networking.info_pokemon

import com.example.pokemon_project.commons.ErrorNetworkException
import com.example.pokemon_project.commons.State
import com.example.pokemon_project.commons.mapToStateFailure
import com.example.pokemon_project.data.PokemonDataService
import com.example.pokemon_project.networking.info_pokemon.model.PokemonInfoResponse

class PokemonInfoNetworkImpl(private val dataService: PokemonDataService) : PokemonInfoNetwork {
    override suspend fun getPokemon(pokemonName: String): State<PokemonInfoResponse> {
        return try {
            val res = dataService.fetchPokemonInfo(
                name = pokemonName
            )
            if (res != null) {
                State.Success(res)
            } else {
                State.Failure("caiu no failure")
            }
        } catch (e: ErrorNetworkException) {
            e.mapToStateFailure("caiu no catch")
        }
    }
}