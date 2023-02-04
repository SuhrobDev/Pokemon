package com.example.data.repository

import androidx.paging.PagingData
import com.example.data.common.ResponseHandler
import com.example.data.common.createPager
import com.example.data.mapper.toData
import com.example.data.mapper.toModel
import com.example.data.remote.dto.main.PokemonDto
import com.example.data.repository.datasource.MainRemoteDatasource
import com.example.domain.common.Resource
import com.example.domain.model.PokemonModel
import com.example.domain.model.SimpleModel
import com.example.domain.model.details.DetailsDto
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val remoteDatasource: MainRemoteDatasource
) : MainRepository, ResponseHandler() {

    /**--------------------------------------HOMEWORK-------------------------------------**/
//    override suspend fun getUserData(): Flow<Resource<UserProfile>> {
//
//    }
    override suspend fun getMain(): Flow<PagingData<PokemonModel>> {
        return createPager { pager ->
            val response = remoteDatasource.getMain(page = pager)
            response.body()?.results!!.map { it.toModel() }
        }.flow
    }

    override suspend fun details(id: String): Flow<Resource<DetailsDto>> = flow {
        val response = remoteDatasource.details(id = id)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Resource.Success(it.toData()))
            }
        } else if (response.code() == 404) {
            emit(Resource.Error(response.message()))
        } else {
            emit(Resource.Error(response.message()))
        }
    }

    override suspend fun getSearchName(name: String): Flow<Resource<SimpleModel>> = flow {
        try {
            val response = remoteDatasource.search(name)
            if (response.code() == 200) {
                response.body()?.let {
                    emit(Resource.Success(SimpleModel(name = it.name, id = it.id)))
                }
            } else if (response.code() == 404) {
                emit(Resource.Error("Error"))
            } else {
                emit(Resource.Error("Error"))
            }
        } catch (e: IOException) {
            emit(Resource.Error("Error"))
        } catch (e: Exception) {
            emit(Resource.Error("Error"))
        }
    }

}

//    override suspend fun getMain(): Flow<PagingData<PokemonModel>> {
//        return createPager { pager ->
//            val response = remoteDatasource.getMain(page = pager)
//            response.body()?.data!!
//
//        }
//    }
