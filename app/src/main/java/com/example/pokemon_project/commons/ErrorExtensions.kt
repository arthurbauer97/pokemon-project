package com.example.pokemon_project.commons

fun Throwable.mapToStateFailure(error:String): State.Failure {
    return State.Failure(error)
}