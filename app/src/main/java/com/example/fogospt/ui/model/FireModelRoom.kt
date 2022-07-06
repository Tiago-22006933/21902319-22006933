package com.example.fogospt.ui.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FireModelRoom(private val dao: FireDao) : FireModel() {

    override fun addFire(
        nome: String,
        numeroCC: String,
        distrito: String,
        conselho: String,
        frequesia: String,
        data: String,
        hora: String,
        status: String,
        fotografia: String,
        distancia: String,
        operacionais: String,
        vehicles: String,
        planes: String,
        lat: Double,
        lng: Double,
        isRegistry: String
    ) {
        val fire = FireRoom(
            fireKey = nome, nome = nome, cartaoCidadao = numeroCC, distrito = distrito,
            conselho = conselho, frequesia = frequesia, data = data, hora = hora, status = status, fotografia = fotografia,
            distancia = distancia, operacionais = operacionais, vehicles = vehicles, planes = planes, lat = lat, lng = lng,
                    isRegistry = isRegistry)

        CoroutineScope(Dispatchers.IO).launch { dao.insert(fire) }
    }

    override fun getAllFires(onFinished: (List<FireParceLable>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val fires = dao.getAll()
            onFinished(fires.map{
                FireParceLable(it.uuid, it.fireKey, it.nome, it.cartaoCidadao, it.distrito,
                    it.conselho, it.frequesia, it.data, it.hora, it.status, it.fotografia, it.distancia, it.operacionais,
                    it.vehicles, it.planes, it.lat, it.lng)
            })
        }
    }

    override fun insertFires(fires: List<FireParceLable>, onFinished: (List<FireParceLable>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val history = fires.map { FireRoom(it.uuid, it.fireKey, it.name, it.cartaoCidadao, it.distrito,
                it.conselho, it.frequesia, it.data, it.hora, it.status, it.fotografia, it.distancia, it.operacionais,
                it.vehicles, it.planes, it.lat, it.lng, it.isRegistry) }
            dao.insertAll(history)
            onFinished(fires)
        }
    }

    override fun deleteAllOperations(onFinished: (List<FireParceLable>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val registeredFires : MutableList<FireRoom> = mutableListOf()
            val allFires = dao.getAll()
            for(fire in allFires){
                if(fire.isRegistry == "true"){
                    registeredFires.add(fire)
                }
            }
            dao.deleteAll()
            onFinished(registeredFires.map{
                FireParceLable(it.uuid, it.fireKey, it.nome, it.cartaoCidadao, it.distrito,
                    it.conselho, it.frequesia, it.data, it.hora, it.status, it.fotografia, it.distancia, it.operacionais,
                    it.vehicles, it.planes, it.lat, it.lng, it.isRegistry)
            })
        }
    }
}