package com.example.pokemon_project.networking.pokemon

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.networking.pokemon.model.PokemonResponse

interface PokemonNetwork {
    suspend fun getPokemons(limit: Int, offset: Int): State<PokemonResponse>
}