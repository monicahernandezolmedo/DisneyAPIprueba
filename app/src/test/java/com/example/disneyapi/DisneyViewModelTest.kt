package com.example.disneyapi
import com.example.disneyapi.viewmodel.DisneyUiState
import com.example.disneyapi.viewmodel.DisneyViewModel

import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement



class TestDispatcherRule(
    private val testDispatcher: TestCoroutineDispatcher = StandardTestDispatcher() as TestCoroutineDispatcher
) : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                // Setup
                TestCoroutineScope(testDispatcher).runBlockingTest {
                    try {
                        base.evaluate()
                    } finally {
                        // Teardown if necessary
                    }
                }
            }
        }
    }
}


class DisneyViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun disneyViewModel_getDisneyCharacters_verifySuccess() = runBlockingTest {
        val viewModel = DisneyViewModel(disneyRepository = NetworkDisneyRepository)
        viewModel.getAllCharacters()
        assertEquals(
            DisneyUiState.Success(NetworkDisneyRepository.getDisneyCharacters()),
            viewModel.uiState.value
        )
    }
}
