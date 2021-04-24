package com.jegadeesan.apod.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jegadeesan.apod.domain.usecase.GetApodByDateUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ApodViewModel : ViewModel(), KoinComponent {

    private val getApodByDateUseCase: GetApodByDateUseCase by inject()

    fun test() {
        viewModelScope.launch(Dispatchers.IO) {
            val a = getApodByDateUseCase.execute("2021-02-01")
            Log.d("ApodViewModelLog", a?.date ?: "")
        }
    }
}