package com.example.marvelhqs.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelhqs.domain.Results
import com.example.marvelhqs.service.Repository
import kotlinx.coroutines.launch

class HqDetailViewModel(val repository: Repository) : ViewModel() {
    internal val listaHQs = MutableLiveData<ArrayList<Results>>()


    fun getHQs(offset: Int) {
        viewModelScope.launch{

            repository.getComics(
                offset,
                12,
                1,
                "f9cb9b2e474b53391d7ef0b68943eb1f",
                "05841f118ae7797fcb7179bc8a6924bf"
            ).also { listaHQs.postValue(it.data.results) }


        }
    }
}