package com.example.dogshelter.data

import com.example.dogshelter.R
import com.example.dogshelter.data.model.Dog

class DataSource {

    fun getDogs(): List<Dog>{
        return listOf(
            Dog("Paula", 13, 6.5, R.drawable.dog1),
            Dog("Edwin", 3, 2.1, R.drawable.dog2),
            Dog("Hannelore", 7, 2.7, R.drawable.dog3),
            Dog("Fluffy", 2, 3.5, R.drawable.dog4)
        )

    }
}