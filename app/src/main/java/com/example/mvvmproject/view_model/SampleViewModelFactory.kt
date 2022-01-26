package com.example.mvvmproject.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.domain.DomainImpl

class SampleViewModelFactory(
    private val domainImpl: DomainImpl
): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(classParameter: Class<T>): T {
        return ListCharactersFragmentViewModel(domainImpl) as T
    }

}