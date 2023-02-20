package com.example.simpleacronyms.viewmodel

import com.example.simpleacronyms.MainDispatcherRule
import com.example.simpleacronyms.repository.AcronymsRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoTestRule

@RunWith(MockitoJUnitRunner::class)
class AcronymsViewModelTest {

    private lateinit var uut: AcronymsViewModel

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val mockitoRule: MockitoTestRule = MockitoJUnit.testRule(this)

    @Mock
    private lateinit var repository: AcronymsRepository

    @Before
    fun setUp() {
        uut = AcronymsViewModel(repository)
    }

    @Test
    fun getLongFormSuccess() {
        uut.getLongForm(successShortForm)
    }

    companion object {
        private const val successShortForm = "HMM"
    }
}