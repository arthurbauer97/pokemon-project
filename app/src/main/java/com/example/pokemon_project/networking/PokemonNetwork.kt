package com.example.pokemon_project.networking

import com.example.pokemon_project.commons.State

interface PokemonNetwork {

    suspend fun getPokemons() : State<PokemonResponse>
}