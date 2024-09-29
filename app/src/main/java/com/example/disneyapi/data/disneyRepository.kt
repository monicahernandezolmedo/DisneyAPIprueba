package com.example.disneyapi.data

import DisneyCharacter

interface DisneyRepository {
    suspend fun getDisneyCharacters(): List<DisneyCharacter>
}
