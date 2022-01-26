package com.example.mvvmproject.api_module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//ordem da receita de bolo aqui hahaha

//1 - crie o cliente para interceptar as chamadas a api e ver se os resultados estao vindo corretamente
//2 - crie um converson de json para objetos para poder pegar o retorno
//3 - crie o retrofit passando o cliente + conversor + o link url que vc quer bater

//configuracao do Okhttp
fun client() =
    OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            //aqui da pra escolher se eu quero ver o body, header e outros
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()


fun gson(): Gson = GsonBuilder().create()

fun retrofit(): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .client(client())
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .build()

fun apiService(): ApiService =
    retrofit().create(ApiService::class.java)