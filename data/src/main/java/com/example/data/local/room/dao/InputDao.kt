package com.example.data.local.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.PokemonModel

@Dao
interface InputDao {

//    @Query("SELECT * FROM result")
//    fun getAllTrainers(): List<ResultDto>

    //    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun saveTrainer(user: TrainerEntity)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun saveTrainers(users: List<ResultDto>)

    //
//    @Update(onConflict = OnConflictStrategy.REPLACE)
//    fun updateUser(user: TrainerEntity)
//
//    @Delete
//    fun deleteUser(user: TrainerEntity)
//
//    @Query("DELETE FROM TrainerEntity")
//    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<PokemonModel>)

    @Query("SELECT * FROM pokemon")
    fun getPokemon(): PagingSource<Int, PokemonModel>

    @Query("DELETE FROM pokemon")
    fun clearAll()


/////////////////////////////////////////////////////
}