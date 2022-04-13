package com.example.fogospt.ui.new_fire

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fogospt.ui.model.FireModel
import com.example.fogospt.ui.model.FiresModel

class NewfireViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text

    //val teste: FireModel = FireModel("teste", 2, "teste", "12/12/12", "teste", "teste")

    //var teste: List<FireModel> = FiresModel.listOfFires


}