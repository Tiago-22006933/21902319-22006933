package com.example.fogospt

import android.app.Application
import com.example.fogospt.ui.model.FireApi
import com.example.fogospt.ui.model.FireDataBase
import com.example.fogospt.ui.model.FireModelRoom
import com.example.fogospt.ui.repository.FireRepository
import com.example.fogospt.ui.location.FusedLocation
import com.example.fogospt.ui.repository.RetrofitBuilder

class FireMain : Application(){

    override fun onCreate() {
        super.onCreate()
        FireRepository.init(this,
            FireModelRoom(FireDataBase.getInstance(this).fireDao()),
            FireApi(RetrofitBuilder.getInstance("https://api-dev.fogos.pt"))
        )
        FusedLocation.start(this)
    }
}