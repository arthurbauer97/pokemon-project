package com.example.pokemon_project.networking.pokemon.model

import com.example.pokemon_project.domain.pokemon.models.PokemonData

fun PokemonResponse.toDomain() =
    PokemonData(
        count = count,
        next = next,
        previous = previous,
        results = results?.map { pokemonResponse ->
            PokemonData.Pokemon(
                name = pokemonResponse?.name,
                url = pokemonResponse?.url
            )
        }
    )