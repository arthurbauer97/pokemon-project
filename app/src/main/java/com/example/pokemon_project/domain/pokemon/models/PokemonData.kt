package com.example.pokemon_project.domain.pokemon.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonData(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon?>?
) : Parcelable {
    @Parcelize
    data class Pokemon(
        var page: Int = 0,
        val name: String?,
        val url: String?
    ) : Parcelable
}