package com.example.simpleacronyms.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleacronyms.repository.AcronymsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AcronymsViewModel @Inject constructor(
    private val repository: AcronymsRepository
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _content = MutableLiveData<List<String>>()
    val content: LiveData<List<String>> = _content

    fun getLongForm(shortForm: String) {
        viewModelScope.launch {
            _content.value = emptyList()
            _isLoading.value = true
            if (shortForm.isNullOrBlank() || shortForm.isEmpty()) {
                _isLoading.value = false
                return@launch
            }

            val response = try {
                repository.getAcromineResponse(shortForm)

            } catch (e: IOException) {
                Log.e(TAG, "IOException, network issue")
                _isLoading.value = false
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                _isLoading.value = false
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                if (response.body()?.isNotEmpty() == true) {
                    val longForms = response.body()?.get(0)?.longForms
                    val listOfLongForms = mutableListOf<String>()
                    longForms?.forEach {
                        listOfLongForms.add(it.longForm)
                    }
                    _content.value = listOfLongForms
                }
            } else {
                Log.e(TAG, "Response error")
            }
            _isLoading.value = false
        }
    }

    companion object {
        private const val TAG = "AcronymsViewModel"
    }
}