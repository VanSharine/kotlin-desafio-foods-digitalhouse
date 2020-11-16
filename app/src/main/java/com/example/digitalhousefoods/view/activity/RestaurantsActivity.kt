package com.example.digitalhousefoods.view.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.view.adapter.MainAdapter
import com.example.digitalhousefoods.viewModel.RestaurantsViewModel


class RestaurantsActivity : AppCompatActivity() {

    private lateinit var viewModel: RestaurantsViewModel

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rvListRestaurants)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DigitalHouseFoods)
        setContentView(R.layout.activity_restaurants)

        viewModel = ViewModelProvider(this).get(RestaurantsViewModel::class.java)
        viewModel.getRestaurants()

        setupObservables()

    }

    private fun setupObservables() {
        viewModel.restaurantsLiveData.observe(this, {
            it?.let { restaurants ->
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@RestaurantsActivity)
                    adapter = MainAdapter(restaurants.restaurantsList) { position ->
                        val intent =
                            Intent(this@RestaurantsActivity, RestaurantsDetailsActivity::class.java)
                        intent.putExtra(KEY_INTENT_RESTAURANT, restaurants.restaurantsList[position])
                        startActivity(intent)
                    }
                }
            }
        })
    }

    companion object {
        const val KEY_INTENT_RESTAURANT = "restaurant"
    }
}