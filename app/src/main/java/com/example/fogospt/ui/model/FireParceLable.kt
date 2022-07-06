package com.example.fogospt.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FireParceLable(
    var uuid: String,
    var fireKey: String,
    var name: String,
    var cartaoCidadao: String,
    var distrito: String,
    var conselho: String,
    var frequesia: String,
    var data: String,
    var hora: String,
    var status: String,
    var fotografia: String,
    var distancia: String,
    var operacionais: String,
    var vehicles: String,
    var planes : String,
    var lat: Double,
    var lng: Double,
    var isRegistry : String = "false",
) : Parcelable