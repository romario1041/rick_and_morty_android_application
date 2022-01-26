package com.example.mvvmproject.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmproject.domain.Domain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListCharactersFragmentViewModel(private val domain: Domain) : ViewModel() {

    private var sampleViewModelMutableLiveData = MutableLiveData<Repository>()
    val sampleViewModelLiveData: LiveData<Repository> = sampleViewModelMutableLiveData
    var currentPage = 1

    fun getCharactersList() {
        viewModelScope.launch(Dispatchers.IO) {
                sampleViewModelMutableLiveData.postValue(domain.getCharacters(currentPage))
        }
    }
}