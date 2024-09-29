package com.example.disneyapi

import DisneyApiService
import DisneyCharacter
import com.example.disneyapi.data.DisneyRepository
class NetworkDisneyRepository(private val disneyApiService: DisneyApiService) : DisneyRepository {
    override suspend fun getDisneyCharacters(): List<DisneyCharacter> {
        val response = disneyApiService.getAllCharacters()
        return response.data // Devuelve la lista de personajes desde la respuesta
    }
}
