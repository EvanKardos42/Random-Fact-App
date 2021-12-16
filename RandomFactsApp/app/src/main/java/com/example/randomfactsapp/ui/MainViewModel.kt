package com.example.randomfactsapp.ui

import androidx.lifecycle.*
import com.example.randomfactsapp.data.FactRepository
import com.example.randomfactsapp.data.model.YearFactModel
import com.example.randomfactsapp.data.utils.APIResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class MainViewModel : ViewModel() {
   private val repository = FactRepository()

    private val _numberFacts = MutableLiveData<APIResponse<List<String>>>()
    val numberFacts:LiveData<APIResponse<List<String>>> = _numberFacts

    private val _yearFact = MutableLiveData<APIResponse<YearFactModel?>>()
    val yearFact:LiveData<APIResponse<YearFactModel?>> = _yearFact

    init {
        set50Facts()
    }

    private fun set50Facts(){
        viewModelScope.launch(Dispatchers.IO) {
            _numberFacts.postValue( APIResponse.loading(null))
            val jsonString =  repository.get50NumberedFacts()
            if (jsonString == null){
               _numberFacts.postValue(APIResponse.error("something went wrong",null))
            }else {
                val jsonObject = JSONObject(jsonString)
                val list = ArrayList<String>()
                for (key in jsonObject.keys()) list.add(jsonObject[key].toString())

               _numberFacts.postValue( APIResponse.success(list))
            }
        }
    }

    fun setYearFact(number: Int){
        viewModelScope.launch(Dispatchers.IO) {
            _yearFact.postValue( APIResponse.loading(null))
            var numberString = ""
            if(number < 10){
                numberString = "0"
            }
            numberString+= number.toString()
            val yearString = "19$numberString"
            val yearFactModel =  repository.getYearRandomFacts(yearString)
            if (yearFactModel == null){
                _yearFact.postValue(APIResponse.error("something went wrong",null))
            }else {
                _yearFact.postValue( APIResponse.success(yearFactModel))
            }
        }
    }
}