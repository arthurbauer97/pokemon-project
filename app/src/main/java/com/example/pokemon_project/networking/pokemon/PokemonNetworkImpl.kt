package com.example.pokemon_project.networking.pokemon

import com.example.pokemon_project.commons.ErrorNetworkException
import com.example.pokemon_project.commons.State
import com.example.pokemon_project.commons.mapToStateFailure
import com.example.pokemon_project.data.PokemonDataService
import com.example.pokemon_project.networking.pokemon.model.PokemonResponse

class PokemonNetworkImpl(private val dataService: PokemonDataService) : PokemonNetwork {

    override suspend fun getPokemons(limit: Int, offset: Int): State<PokemonResponse> {
        return try {
            val res = dataService.fetchPokemonList(
                limit = limit,
                offset = offset
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