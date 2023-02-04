package com.example.domain.use_case.main

import androidx.paging.PagingData
import com.example.domain.model.PokemonModel
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend operator fun invoke(): Flow<PagingData<PokemonModel>> {
        return repository.getMain()
    }

}