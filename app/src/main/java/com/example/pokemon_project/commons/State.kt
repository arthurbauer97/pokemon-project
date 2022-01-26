package com.example.pokemon_project.commons

sealed class State<out T>{
    data class Success<T>(val data: T) : State<T>()
    data class Failure(val error: String) : State<Nothing>()
}
