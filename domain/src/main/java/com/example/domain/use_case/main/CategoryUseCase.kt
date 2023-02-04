package com.example.domain.use_case.main

import kotlinx.coroutines.flow.Flow
import com.example.domain.common.Resource
import com.example.domain.repository.MainRepository
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val repository: MainRepository
) {
//    suspend operator fun invoke(): Flow<Resource<List<AllCategoryModel>>> {
//        return repository.getForumCategory()
//    }
}