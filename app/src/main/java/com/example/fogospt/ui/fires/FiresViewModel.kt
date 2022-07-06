package com.example.fogospt.ui.fires

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.fogospt.ui.model.FireParceLable
import com.example.fogospt.ui.repository.FireRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FiresViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = FireRepository.getInstance()

    fun getAllFires(callback: (List<FireParceLable>) -> List<FireParceLable>){
        val list: List<FireParceLable>
        CoroutineScope(Dispatchers.Main).launch {
           list =  repository.getAllFires(callback)
        }
    }

    fun getAllRegistros(onFinished: (List<FireParceLable>) -> Unit){
        repository.getAllRegistros(onFinished)
    }

    fun getAllFiresList(): List<FireParceLable> {
        return repository.getAllFiresList()
    }

    fun getActiveFire() : List<FireParceLable> {
        return repository.getActiveFires()
    }

    fun getDistrictWithMostFires() : String {
        return repository.getDistrictWithMostFires()
    }


    fun deleteFire(fire: FireParceLable, onSucess: (List<FireParceLable>) -> Unit) {
        return repository.deleteFire(fire, onSucess)
    }
}