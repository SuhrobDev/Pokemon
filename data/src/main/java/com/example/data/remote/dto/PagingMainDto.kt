package com.example.data.remote.dto

data class PagingMainDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: T,
)
