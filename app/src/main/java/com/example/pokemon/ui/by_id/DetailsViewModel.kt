package com.example.pokemon.ui.by_id

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.common.Resource
import com.example.domain.model.details.DetailsDto
import com.example.domain.use_case.main.DetailsUseCase
import com.example.pokemon.common.UIObjectState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DetailsViewModel @Inject constructor(private val useCase: DetailsUseCase) : ViewModel() {
    private val _details = MutableStateFlow(UIObjectState<DetailsDto>())
    val details = _details.asStateFlow()


    suspend fun getDetails(id: String) {
        Log.d("SSSSSSSSSSSSSS", "keldi ")
        useCase.invoke(id = id).onEach { it ->
            when (it) {
                is Resource.Error -> {
                    Log.d("SSSSSSSSSSSSSS", "getPodcastCategory: ${it.message}")
                    _details.value = UIObjectState(it.message ?: "")
                }
                is Resource.Loading -> {
                    _details.update { it.copy(isLoading = true) }

//                    _podcastInfo.value = UIListState(isLoading = true)
                }
                is Resource.Success -> {
                    _details.value = UIObjectState(data = it.data)
                    Log.d("SSSSSSSSSSSSSS", "PodcastsDetailViewModel: ${it.data}")
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

}