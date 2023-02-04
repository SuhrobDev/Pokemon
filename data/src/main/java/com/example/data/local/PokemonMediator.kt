package com.example.data.local

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.data.local.room.AppDatabase
import com.example.data.local.room.RemoteKeys
import com.example.data.mapper.toModel
import com.example.data.remote.MainService
import com.example.domain.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class PokemonMediator(
    private val db: AppDatabase,
    private val service: MainService
) : RemoteMediator<Int, PokemonModel>() {

    private val STARTING_PAGE_INDEX = 1

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonModel>
    ): MediatorResult {
        val pageKeyData = getKeyPageData(loadType, state)
        val page = when (pageKeyData) {
            is MediatorResult.Success -> {
                return pageKeyData
            }
            else -> {
                pageKeyData as Int
            }
        }

        try {
            val response = service.getMain(page)
            val endOfList = response.body()?.results?.isEmpty()
            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.remoteDao().clearAll()
                    db.inputDao().clearAll()
                }
                val prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1
                val nextKey = if (endOfList!!) null else page + 1
                val keys = response.body()?.results?.map {
                    RemoteKeys(it.name, prevKey, nextKey)
                }
                db.remoteDao().insertRemote(keys ?: emptyList())
                db.inputDao().insert(response.body()?.results!!.map { it.toModel() } ?: emptyList())
            }
            return MediatorResult.Success(endOfPaginationReached = endOfList!!)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getKeyPageData(
        loadType: LoadType,
        state: PagingState<Int, PokemonModel>
    ): Any {
        return when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRefreshRemoteKey(state)
                remoteKeys?.nextKey?.minus(1) ?: STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getFirstRemoteKey(state)
                val prevKey = remoteKeys?.prevKey ?: MediatorResult.Success(
                    endOfPaginationReached = false
                )
                prevKey
            }
            LoadType.APPEND -> {
                val remoteKeys = getLastRemoteKey(state)
                val nextKey = remoteKeys?.nextKey ?: MediatorResult.Success(
                    endOfPaginationReached = true
                )
                nextKey
            }
        }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, PokemonModel>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.pages
                .firstOrNull { it.data.isNotEmpty() }
                ?.data?.firstOrNull()
                ?.let { dog -> db.remoteDao().getRemoteKeys(dog.name) }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, PokemonModel>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.pages
                .lastOrNull { it.data.isNotEmpty() }
                ?.data?.lastOrNull()
                ?.let { dog -> db.remoteDao().getRemoteKeys(dog.name) }
        }
    }

    private suspend fun getRefreshRemoteKey(state: PagingState<Int, PokemonModel>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.anchorPosition?.let { position ->
                state.closestItemToPosition(position)?.name?.let { repId ->
                    db.remoteDao().getRemoteKeys(repId)
                }
            }
        }
    }
}