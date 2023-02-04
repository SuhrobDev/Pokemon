package com.example.data.remote

import com.example.data.remote.dto.PagingMainDto
import com.example.data.remote.dto.details.DetailsDto
import com.example.data.remote.dto.main.PokemonDto
import com.example.domain.common.Resource
import retrofit2.Response
import retrofit2.http.*

interface MainService {

    @GET("pokemon/{name}")
    suspend fun details(
        @Path("name") name: String
    ): Response<DetailsDto>

    @GET("pokemon")
    suspend fun getMain(
        @Query("offset") page: Int,
        @Query("limit") limit: Int = 15
    ): Response<PagingMainDto<List<PokemonDto>>>

    @GET("pokemon")
    suspend fun search(
        @Query("search") search: String
    ): Response<PagingMainDto<List<PokemonDto>>>

//    @GET("podcasts/{id}")
//    suspend fun getPodcastByCategory(
//        @Path("id") id: String,
//        @Query("page") page: Int,
//        @Query("limit") limit: Int = 10
//    ): Response<MainResponseDto<PagingMainDto<List<PodcastDataDto>>>>
}
