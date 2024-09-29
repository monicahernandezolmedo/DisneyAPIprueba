package com.example.disneyapi

import DisneyApiService
import DisneyCharacter
import androidx.media3.test.utils.FakeDataSource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class NetworkDisneyRepositoryTest  {
    @Test
    fun networkDisneyRepository_getCharacters_verifyCharacterList() = runBlocking {
        val repository = NetworkDisneyRepository(
            disneyApiService = FakeDisneyApiService()
        )
        assertEquals(FakeDataSource.characterList, repository.getDisneyCharacters())
    }
}
