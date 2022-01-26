package com.example.pokemon_project.data

import com.example.pokemon_project.commons.State
import com.example.pokemon_project.networking.PokemonInfoResponse
import com.example.pokemon_project.networking.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonDataService {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): State<PokemonResponse>

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(@Path("name") name: String): State<PokemonInfoResponse>
}
