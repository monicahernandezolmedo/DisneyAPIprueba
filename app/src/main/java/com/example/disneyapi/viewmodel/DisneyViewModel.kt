package com.example.disneyapi.viewmodel

import DisneyCharacter
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.IOException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import androidx.compose.ui.platform.LocalConfiguration
import com.example.disneyapi.data.DisneyRepository


sealed class DisneyUiState {
    object Loading : DisneyUiState()
    data class Success(val characters: List<DisneyCharacter>) : DisneyUiState()
    data class Error(val message: String) : DisneyUiState()
}

class DisneyViewModel(private val disneyRepository: DisneyRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<DisneyUiState>(DisneyUiState.Loading)
    val uiState: StateFlow<DisneyUiState> = _uiState

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            _uiState.value = DisneyUiState.Loading
            try {
                val characters = disneyRepository.getDisneyCharacters()
                _uiState.value = DisneyUiState.Success(characters)
            } catch (e: IOException) {
                _uiState.value = DisneyUiState.Error("No internet connection")
            } catch (e: HttpException) {
                _uiState.value = DisneyUiState.Error("Error: ${e.message()}")
            } catch (e: Exception) {
                _uiState.value = DisneyUiState.Error("Error: ${e.message}")
            }
        }
    }
}
