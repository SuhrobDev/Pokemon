package com.example.data.repository.datasource

import com.example.data.remote.dto.PagingMainDto
import com.example.data.remote.dto.details.DetailsDto
import com.example.data.remote.dto.main.PokemonDto
import retrofit2.Response

interface MainRemoteDatasource {

    suspend fun getMain(
        page: Int,
    ): Response<PagingMainDto<List<PokemonDto>>>

    suspend fun details(id: String): Response<DetailsDto>
    suspend fun search(name: String): Response<DetailsDto>
}