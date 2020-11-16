package com.example.digitalhousefoods.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantDetails(
    val idMenu:Int,
    val imagemMenu :String,
    val nomeMenu :String,
    val descricaoMenu :String
): Parcelable