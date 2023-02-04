package com.example.pokemon.ui.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.model.PokemonModel
import com.example.domain.model.SimpleModel
import com.example.domain.use_case.main.MainUseCase
import com.example.pokemon.common.UIObjectState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel() {

    private val _search = MutableStateFlow(UIObjectState<SimpleModel>())
    val search = _search.asStateFlow()

    fun getName(name: String) {
        viewModelScope.launch {
            useCase.getName(name).onEach {
                when (it) {
                    is Resource.Error -> {
                        _search.value = UIObjectState(it.message ?: "")
                    }
                    is Resource.Loading -> {
                        _search.value = UIObjectState(isLoading = true)
                    }
                    is Resource.Success -> {
                        _search.value = UIObjectState(data = it.data)
                    }
                }

            }.launchIn(CoroutineScope(Dispatchers.IO))
        }
    }

}