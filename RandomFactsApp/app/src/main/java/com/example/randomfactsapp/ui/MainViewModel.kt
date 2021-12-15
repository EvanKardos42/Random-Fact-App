package com.example.randomfactsapp.ui

import androidx.lifecycle.*
import com.example.randomfactsapp.data.FactRepository
import com.example.randomfactsapp.data.model.FactYearModel
import com.example.randomfactsapp.data.utils.APIResponse
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainViewModel : ViewModel() {
   private val repository = FactRepository()

    private val _numberFacts = MutableLiveData<APIResponse<List<String>>>()
    val numberFacts:LiveData<APIResponse<List<String>>> = _numberFacts
    private val _yearFact = MutableLiveData<APIResponse<FactYearModel>>()
    val yearFact:LiveData<APIResponse<FactYearModel>> = _yearFact

    init {
        fetch50Facts()
    }

    private fun fetch50Facts(){
        viewModelScope.launch {
            _numberFacts.postValue( APIResponse.loading(null))
            val jsonString =  repository.get50NumberedFacts()
            if (jsonString == null){
               _numberFacts.postValue(APIResponse.error("something went wrong",null))
            }else {
                val jsonObject = JSONObject(jsonString!!)
                val list = ArrayList<String>()
                for (key in jsonObject.keys()) list.add(jsonObject[key].toString())

               _numberFacts.postValue( APIResponse.success(list))
            }
        }
    }
}