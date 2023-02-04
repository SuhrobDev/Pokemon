package com.example.pokemon.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.data.local.PokemonMediator
import com.example.data.local.room.AppDatabase
import com.example.data.remote.MainService
import com.example.domain.model.PokemonModel
import com.example.domain.use_case.main.MainUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCase: MainUseCase,
    private val mainService: MainService,
    private val database: AppDatabase
) : ViewModel() {

    suspend fun getMainPaging(): Flow<PagingData<PokemonModel>> {
        return useCase.invoke().cachedIn(viewModelScope)
    }

    @ExperimentalPagingApi
    fun getAllDogs(): Flow<PagingData<PokemonModel>> = Pager(
        config = PagingConfig(100, enablePlaceholders = false),
        pagingSourceFactory = { database.inputDao().getPokemon() },
        remoteMediator = PokemonMediator(database, mainService)
    ).flow.cachedIn(viewModelScope)
}