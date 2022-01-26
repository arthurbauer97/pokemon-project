package com.example.pokemon_project.networking

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.data.PokemonDataService

class PokemonNetworkImpl(private val dataService: PokemonDataService) : PokemonNetwork {
    override suspend fun getPokemons(): State<PokemonResponse> {
        TODO()
    }
}