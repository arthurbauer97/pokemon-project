package com.example.pokemon_project.domain.info_pokemon.models


data class PokemonInfoData(
    val id: Int?,
    val name: String?,
    val height: Int?,
    val weight: Int?,
    val experience: Int?,
    val types: List<TypeResponse?>?,
) {
    data class TypeResponse(
        val slot: Int?,
        val type: Type?
    )


    data class Type(
        val name: String?
    )
}
