package com.example.digitalhousefoods.view.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.model.Restaurant
import com.example.digitalhousefoods.view.activity.RestaurantsActivity.Companion.KEY_INTENT_RESTAURANT
import com.example.digitalhousefoods.view.adapter.MainAdapterDetails
import com.example.digitalhousefoods.viewModel.RestaurantsDetailsViewModel
import kotlinx.android.synthetic.main.activity_restaurant_details.*



class RestaurantsDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: RestaurantsDetailsViewModel

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rvListDetailsRestaurants)
    }

    private var restaurants: Restaurant? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DigitalHouseFoods)
        setContentView(R.layout.activity_restaurant_details)
        supportActionBar?.hide()
        initComponent()
        restaurants = intent.getParcelableExtra(KEY_INTENT_RESTAURANT)
        setupUser()

        viewModel = ViewModelProvider(this).get(RestaurantsDetailsViewModel::class.java)
        viewModel.getRestaurantsDetails()

        setupObservables()

    }

    private fun setupObservables() {
        viewModel.restaurantsDetailsLiveData.observe(this, {
            it?.let { restaurantsDetails ->
                recyclerView.apply {
                    layoutManager = GridLayoutManager(this@RestaurantsDetailsActivity, 2)
                    adapter = MainAdapterDetails(restaurantsDetails.restaurantsDetailsList) { position ->
                        val intent =
                            Intent(this@RestaurantsDetailsActivity, PlateActivity::class.java)
                        intent.putExtra(KEY_INTENT_RESTAURANT_DETAILS, restaurantsDetails.restaurantsDetailsList[position])
                        startActivity(intent)
                    }
                }
            }
        })
    }

    private fun initComponent() {
        this.ibDetailsBack.setOnClickListener {
            finish()
        }
    }

    private fun setupUser() {
        Glide.with(this).load(restaurants?.imagem).into(ivDetailsMainImage)
        tvDetailsMainName.text = restaurants?.nome
    }

    companion object {
        const val KEY_INTENT_RESTAURANT_DETAILS = "restaurantDetails"
    }
}


