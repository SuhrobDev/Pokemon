package com.example.domain.use_case.main

import com.example.domain.common.Resource
import com.example.domain.model.details.DetailsDto
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend operator fun invoke(id: String): Flow<Resource<DetailsDto>> {
//        Log.d(TAG, "invoke: ")
        return repository.details(id = id)
    }
}