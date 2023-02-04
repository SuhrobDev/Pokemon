package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.common.Resource
import com.example.domain.model.PokemonModel
import com.example.domain.model.details.DetailsDto
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun getMain(): Flow<PagingData<PokemonModel>>

    suspend fun details(id: String): Flow<Resource<DetailsDto>>
    /** ------------------------------------          Forum         ------------------------------------------------------------------------  */


}