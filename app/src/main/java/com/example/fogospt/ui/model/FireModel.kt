package com.example.fogospt.ui.model

import java.util.*

class FireModel {

    var name: String
    var cartaoCidadao: Long
    var destrito: String
    var data: Date
    var hora: String
    var fotografia: String

    constructor(
        name: String,
        cartaoCidadao: Long,
        destrito: String,
        data: Date,
        hora: String,
        fotografia: String
    ) {
        this.name = name
        this.cartaoCidadao = cartaoCidadao
        this.destrito = destrito
        this.data = data
        this.hora = hora
        this.fotografia = fotografia
    }

}