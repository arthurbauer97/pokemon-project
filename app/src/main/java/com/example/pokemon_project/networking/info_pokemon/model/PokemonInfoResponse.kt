package com.example.pokemon_project.networking.info_pokemon.model

import com.google.gson.annotations.SerializedName

data class PokemonInfoResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("weight")
    val weight: Int?,
    @SerializedName("experience")
    val experience: Int?,
    @SerializedName("types")
    val types: List<TypeResponse?>?,
) {
    data class TypeResponse(
        @SerializedName("slot")
        val slot: Int?,
        @SerializedName("type")
        val type: Type?
    )
    data class Type(
        @SerializedName("name")
        val name: String?
    )
}