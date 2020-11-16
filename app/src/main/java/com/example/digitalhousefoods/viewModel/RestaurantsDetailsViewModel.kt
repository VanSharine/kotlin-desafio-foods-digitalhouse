package com.example.digitalhousefoods.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.digitalhousefoods.model.RestaurantDetails
import com.example.digitalhousefoods.model.Restaurants
import com.example.digitalhousefoods.model.RestaurantsDetails
import com.example.digitalhousefoods.model.restaurants.RestaurantsBusiness
import com.example.digitalhousefoods.model.restaurantsDetails.RestaurantsDetailsBusiness

class RestaurantsDetailsViewModel : ViewModel() {
    val restaurantsDetailsLiveData: MutableLiveData<RestaurantsDetails> = MutableLiveData()
    private val restaurantsDetailsBusiness = RestaurantsDetailsBusiness()

    fun getRestaurantsDetails() {
        restaurantsDetailsLiveData.postValue(
            restaurantsDetailsBusiness.getRestaurantsDetails()
        )
    }
}