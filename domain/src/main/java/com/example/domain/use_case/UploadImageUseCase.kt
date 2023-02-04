package com.example.domain.use_case

import android.util.Log
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import com.example.domain.common.Resource
import com.example.domain.repository.MainRepository
import javax.inject.Inject

class UploadImageUseCase @Inject constructor(private val repository: MainRepository) {
//    suspend operator fun invoke(file:MultipartBody.Part):Flow<Resource<String>>{
//        Log.d("EEEEEE", "uploadImage useCase: $file")
//        return repository.uploadImage(file)
//    }
}