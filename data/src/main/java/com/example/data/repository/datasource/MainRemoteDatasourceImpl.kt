package com.example.data.repository.datasource

import com.example.data.remote.MainService
import com.example.data.remote.dto.PagingMainDto
import com.example.data.remote.dto.details.DetailsDto
import com.example.data.remote.dto.main.PokemonDto
import retrofit2.Response
import javax.inject.Inject

class MainRemoteDatasourceImpl @Inject constructor(
    private val mainService: MainService
) : MainRemoteDatasource {

    override suspend fun getMain(page: Int): Response<PagingMainDto<List<PokemonDto>>> {
        return mainService.getMain(page = page)
    }

    override suspend fun details(id: String): Response<DetailsDto> {
        return mainService.details(name = id)
    }
}

