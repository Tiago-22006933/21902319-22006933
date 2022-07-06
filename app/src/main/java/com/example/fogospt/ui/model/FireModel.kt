package com.example.fogospt.ui.model


abstract class FireModel {
    abstract fun addFire(nome : String, numeroCC : String, distrito : String,
                         conselho : String, frequesia : String, data : String, hora : String,
                         status : String, fotografia: String, distancia : String, operacionais : String,
                         vehicles : String, planes : String,
                         lat : Double, lng : Double, isRegistry : String
    )
    abstract fun getAllFires(onFinished: (List<FireParceLable>) -> Unit)
    abstract fun insertFires(fires: List<FireParceLable>, onFinished: (List<FireParceLable>) -> Unit)
    abstract fun deleteAllOperations(onFinished: (List<FireParceLable>) -> Unit)
}