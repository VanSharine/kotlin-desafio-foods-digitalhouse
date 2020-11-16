package com.example.digitalhousefoods.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.digitalhousefoods.model.Restaurant
import com.example.digitalhousefoods.model.Restaurants
import com.example.digitalhousefoods.model.restaurants.RestaurantsBusiness

class RestaurantsViewModel : ViewModel() {
    val restaurantsLiveData: MutableLiveData<Restaurants> = MutableLiveData()
    private val restaurantsBusiness = RestaurantsBusiness()

    fun getRestaurants() {
        restaurantsLiveData.postValue(
            restaurantsBusiness.getRestaurants()
        )
    }
}