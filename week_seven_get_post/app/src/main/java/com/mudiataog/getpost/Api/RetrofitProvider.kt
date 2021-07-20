package com.mudiataog.getpost.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ict-yep-backend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val placeHolderAPI: PlaceHolderAPI = retrofit.create(PlaceHolderAPI::class.java)
}