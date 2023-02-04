package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonModel(
    var _id: String? = "",
    @PrimaryKey
    val name: String,
    val url: String
)