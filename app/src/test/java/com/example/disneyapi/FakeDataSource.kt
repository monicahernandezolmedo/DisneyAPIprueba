package com.example.disneyapi

import DisneyCharacter
import DisneyCharacterResponseList
import Info
import com.example.disneyapi.data.DisneyRepository
object FakeDataSource {
    val characterList = listOf(
        DisneyCharacter(
            _id = 1,
            films = listOf("Film 1", "Film 2"),
            shortFilms = listOf("Short 1"),
            tvShows = listOf("Show 1", "Show 2"),
            videoGames = listOf("Game 1"),
            parkAttractions = listOf("Attraction 1"),
            allies = listOf("Ally 1", "Ally 2"),
            enemies = listOf("Enemy 1", "Enemy 2"),
            name = "Mickey Mouse",
            imageUrl = "https://upload.wikimedia.org/wikipedia/en/d/d4/Mickey_Mouse.png",
            url = "https://disneyapi.dev/characters/1"
        ),
        DisneyCharacter(
            _id = 2,
            films = listOf("Film 3"),
            shortFilms = listOf(),
            tvShows = listOf(),
            videoGames = listOf(),
            parkAttractions = listOf(),
            allies = listOf(),
            enemies = listOf(),
            name = "Donald Duck",
            imageUrl = "https://upload.wikimedia.org/wikipedia/en/8/85/Donald_Duck.png",
            url = "https://disneyapi.dev/characters/2"
        )
    )
}
