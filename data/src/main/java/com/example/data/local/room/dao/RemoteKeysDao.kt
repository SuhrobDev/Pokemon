package com.example.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.room.RemoteKeys
import com.example.domain.model.PokemonModel

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRemote(list: List<RemoteKeys>)

    @Query("SELECT * FROM remoteKey WHERE repoId = :id")
    fun getRemoteKeys(id:String) : RemoteKeys

    @Query("DELETE FROM remoteKey")
    fun clearAll()
}