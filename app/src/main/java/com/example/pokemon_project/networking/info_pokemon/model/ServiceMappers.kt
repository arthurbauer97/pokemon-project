package com.example.pokemon_project.networking.info_pokemon.model

import com.example.pokemon_project.domain.info_pokemon.models.PokemonInfoData

fun PokemonInfoResponse.toDomain() =
    PokemonInfoData(
        id = id,
        name = name,
        height = height,
        weight = weight,
        experience = experience,
        types = types?.map { typeResponse ->
            PokemonInfoData.TypeResponse(
                slot = typeResponse?.slot,
                type = PokemonInfoData.Type(
                    name = typeResponse?.type?.name
                )
            )
        }
    )