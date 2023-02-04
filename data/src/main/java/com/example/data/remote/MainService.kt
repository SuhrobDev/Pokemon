package com.example.data.remote

import com.example.data.remote.dto.PagingMainDto
import com.example.data.remote.dto.details.DetailsDto
import com.example.data.remote.dto.main.PokemonDto
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
        @Query("limit") limit: Int = 200
    ): Response<PagingMainDto<List<PokemonDto>>>

    @GET("pokemon/{name}")
    suspend fun search(
        @Path("name") name: String
    ): Response<DetailsDto>

//    @GET("podcasts/{id}")
//    suspend fun getPodcastByCategory(
//        @Path("id") id: String,
//        @Query("page") page: Int,
//        @Query("limit") limit: Int = 10
//    ): Response<MainResponseDto<PagingMainDto<List<PodcastDataDto>>>>
}
