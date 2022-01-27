package com.example.pokemon_project.commons.ui

sealed class ViewState<out T>{
    object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Failure(val error: String) : ViewState<Nothing>()
}
