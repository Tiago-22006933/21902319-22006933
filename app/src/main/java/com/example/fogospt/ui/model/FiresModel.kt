package com.example.fogospt.ui.model

import java.util.*

object FiresModel{

    val listOfFires: MutableList<FireModel> = mutableListOf()

    init {
        listOfFires.add(FireModel("Tiago",12345678, "Lisboa", Date(2022, 3,5), "17:00", "aaaa"))
        listOfFires.add(FireModel("Ana",87654321, "Porto", Date(2022, 4,6), "09:32", "bbbb"))
    }

}