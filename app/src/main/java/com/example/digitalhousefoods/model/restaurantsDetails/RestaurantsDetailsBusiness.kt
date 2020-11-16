package com.example.digitalhousefoods.model.restaurantsDetails

import com.example.digitalhousefoods.model.RestaurantsDetails


class RestaurantsDetailsBusiness {

    private val repository: RestaurantsDetailsRepository by lazy {
        RestaurantsDetailsRepository()
    }

    fun getRestaurantsDetails(): RestaurantsDetails {
        return repository.getRestaurantsDetails()
    }
}