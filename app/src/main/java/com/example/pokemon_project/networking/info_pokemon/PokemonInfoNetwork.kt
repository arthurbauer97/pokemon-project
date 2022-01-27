package com.example.pokemon_project.networking.info_pokemon

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.networking.info_pokemon.model.PokemonInfoResponse

interface PokemonInfoNetwork {
    suspend fun getPokemon(pokemonName: String) : State<PokemonInfoResponse>
}