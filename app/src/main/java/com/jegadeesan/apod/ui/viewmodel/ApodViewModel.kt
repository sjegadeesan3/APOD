package com.jegadeesan.apod.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jegadeesan.apod.data.util.DateTimeUtil
import com.jegadeesan.apod.domain.data.Apod
import com.jegadeesan.apod.domain.usecase.GetApodByDateUseCase
import com.jegadeesan.apod.domain.usecase.GetLatestApodListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

class ApodViewModel : ViewModel(), KoinComponent {

    private val getApodByDateUseCase: GetApodByDateUseCase by inject()
    private val getLatestApodListUseCase: GetLatestApodListUseCase by inject()

    private val mApodLiveDate = MutableLiveData<Apod>()
    val apodLiveDate : LiveData<Apod>
        get() = mApodLiveDate

    private val mLatest30DaysApod = MutableLiveData<List<Apod>>()
    private val latest30DaysApod : LiveData<List<Apod>>
        get() = mLatest30DaysApod

    fun getApod(date: Date) {
        viewModelScope.launch(Dispatchers.IO) {
            val selectedDate = DateTimeUtil.convertDateToString(date)
            val result = getApodByDateUseCase.execute(selectedDate)
            result?.let { apod ->
                mApodLiveDate.postValue(apod)
            }
        }
    }

    fun getLatest30DaysApodData(): LiveData<List<Apod>> {
        viewModelScope.launch(Dispatchers.IO) {
            val latestApodList = getLatestApodListUseCase.execute(30)
            latestApodList?.let {
                mLatest30DaysApod.postValue(it)
            } ?: run {
                mLatest30DaysApod.postValue(listOf())
            }
        }
        return latest30DaysApod
    }

    fun getFormattedDate(date: Date): String {
        return DateTimeUtil.convertDateToString(date, "dd/MMM/yyyy")
    }
}