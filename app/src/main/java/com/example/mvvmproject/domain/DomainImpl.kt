package com.example.mvvmproject.domain

import com.example.mvvmproject.api_module.apiService
import com.example.mvvmproject.view_model.Repository

class DomainImpl : Domain {

    override suspend fun getCharacters(page: Int): Repository {
        return try {
            Repository.Sucess(apiService().getCharacters(page).results)
        } catch (error: Throwable){
            Repository.Fail(error.localizedMessage)
        }
    }
}