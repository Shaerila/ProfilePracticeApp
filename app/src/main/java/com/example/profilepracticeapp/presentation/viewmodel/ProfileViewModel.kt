package com.example.profilepracticeapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilepracticeapp.data.repository.ProfileRepository
import com.example.profilepracticeapp.domain.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    val repository: ProfileRepository = ProfileRepository()
) : ViewModel() {


    // The MutableStateFlow both gather and emits data and is changeable
    private val _userInformation = MutableStateFlow<List<Result>>(emptyList())

    // The StateFlow is not changeable and emit the data some the Mutable
    val userInformation: StateFlow<List<Result>> = _userInformation

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _userInformation.value = getDataFromRepo()
        }
    }

    suspend fun getDataFromRepo(): List<Result> {
        return repository.getDataFromWebservice().results
    }

}