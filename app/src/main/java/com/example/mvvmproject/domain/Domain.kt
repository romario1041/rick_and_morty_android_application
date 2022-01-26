package com.example.mvvmproject.domain

import com.example.mvvmproject.view_model.Repository

interface Domain {

    suspend fun getCharacters(page: Int): Repository
}