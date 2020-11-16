package com.example.digitalhousefoods.view.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.model.RestaurantDetails
import com.example.digitalhousefoods.view.activity.RestaurantsDetailsActivity.Companion.KEY_INTENT_RESTAURANT_DETAILS
import kotlinx.android.synthetic.main.activity_plate.*

class PlateActivity : AppCompatActivity() {

    private var restaurantsDetails: RestaurantDetails? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_DigitalHouseFoods)
        setContentView(R.layout.activity_plate)
        supportActionBar?.hide()
        restaurantsDetails = intent.getParcelableExtra(KEY_INTENT_RESTAURANT_DETAILS)
        setupUser()
        initComponent()
    }

    private fun initComponent() {
        ibBack.setOnClickListener {
            finish()
        }
    }

    private fun setupUser() {
        Glide.with(this).load(restaurantsDetails?.imagemMenu).into(ivPlateImage)
        tvPlateName.text = restaurantsDetails?.nomeMenu
        tvPlateDescription.text = restaurantsDetails?.descricaoMenu
    }
}