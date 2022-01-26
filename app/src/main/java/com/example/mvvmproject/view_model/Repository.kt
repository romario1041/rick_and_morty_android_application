package com.example.mvvmproject.view_model

import androidx.lifecycle.MutableLiveData
import com.example.mvvmproject.model.ResultsItem

//melhorar essa clase usando generics no parametro do sucess para qualquer view model poder usar, nao so a de comunicacao com o usuario
sealed class Repository{
    data class Sucess(val response: List<ResultsItem>) : Repository()
    data class Fail (val fail: String): Repository()
}
