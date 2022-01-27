package com.example.pokemon_project.networking.pokemon.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<Pokemon?>?
) : Parcelable {
    @Parcelize
    data class Pokemon(
        @SerializedName("page")
        var page: Int = 0,
        @SerializedName("name")
        val name: String?,
        @SerializedName("url")
        val url: String?
    ) : Parcelable
}