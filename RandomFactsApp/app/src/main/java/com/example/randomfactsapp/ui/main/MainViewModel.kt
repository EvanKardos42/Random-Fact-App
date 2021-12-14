package com.example.randomfactsapp.ui.main

import androidx.lifecycle.*
import com.example.randomfactsapp.data.FactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainViewModel : ViewModel() {
   private val repository = FactRepository()

    private val _numberFacts = liveData<List<String>> {
        val jsonString =  repository.get50NumberedFacts()
        val json = JSONObject(jsonString)
        val list = ArrayList<String>()
        for(key in json.keys()) {
            list.add(json[key].toString())
        }
        emit(list)
    }

    val numberFacts:LiveData<List<String>> = _numberFacts

}