package com.example.pokemon_project.di

import com.example.pokemon_project.domain.info_pokemon.repositories.PokemonInfoRepository
import com.example.pokemon_project.domain.info_pokemon.use_case.GetPokemonInfoUseCase
import com.example.pokemon_project.domain.pokemon.repositories.PokemonRepository
import com.example.pokemon_project.domain.pokemon.use_case.GetPokemonUseCase
import com.example.pokemon_project.networking.info_pokemon.PokemonInfoNetwork
import com.example.pokemon_project.networking.info_pokemon.PokemonInfoNetworkImpl
import com.example.pokemon_project.networking.pokemon.PokemonNetwork
import com.example.pokemon_project.networking.pokemon.PokemonNetworkImpl
import com.example.pokemon_project.remote.ClientService
import com.example.pokemon_project.services.info_pokemon.PokemonInfoRepositoryImpl
import com.example.pokemon_project.services.pokemon.PokemonRepositoryImpl
import com.example.pokemon_project.ui.PokemonInfoViewModel
import com.example.pokemon_project.ui.PokemonViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    //service
    private val serviceModule = module {
        single {
            ClientService().configureServicePokemons()
        }
    }

    //useCase
    private val useCaseModule = module {
        factory { GetPokemonUseCase(pokemonRepository = get()) }
        factory { GetPokemonInfoUseCase(pokemonInfoRepository = get()) }
    }

    //viewModel
    private val viewModelModule = module {
        viewModel {
            PokemonInfoViewModel(
                dispatcher = Dispatchers.IO,
                pokemonInfoUseCase = get()
            )
        }

        viewModel {
            PokemonViewModel(
                dispatcher = Dispatchers.IO,
                pokemonUseCase = get()
            )
        }
    }

    //repository
    private val repositoryModule = module {

        factory<PokemonRepository> { PokemonRepositoryImpl(get()) }

        factory<PokemonInfoRepository> { PokemonInfoRepositoryImpl(get()) }
    }

    //network
    private val networkModule = module {
        factory<PokemonNetwork> { PokemonNetworkImpl(get()) }
        factory<PokemonInfoNetwork> { PokemonInfoNetworkImpl(get()) }
    }

    val modules = listOf(serviceModule, useCaseModule, viewModelModule, repositoryModule,
        networkModule)
}