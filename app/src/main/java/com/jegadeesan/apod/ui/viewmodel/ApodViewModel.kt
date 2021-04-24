package com.jegadeesan.apod.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jegadeesan.apod.domain.usecase.GetApodByDateUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApodViewModel : ViewModel() {

    fun test() {
        viewModelScope.launch(Dispatchers.IO) {
            GetApodByDateUseCase(null).execute("")
        }
    }
}