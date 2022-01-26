package com.example.mvvmproject.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmproject.model.ResultsItem

class HostActivityViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<ResultsItem>()
    val liveData = mutableLiveData

    fun sendItem(resultsItem: ResultsItem) {
        mutableLiveData.value = resultsItem
    }
}