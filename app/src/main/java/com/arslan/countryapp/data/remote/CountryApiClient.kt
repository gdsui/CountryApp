package com.arslan.countryapp.data.remote

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryApiClient {
   private val api=Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(CountryApi::class.java)

   fun getDataFomApi():Single<List<CountryModel>>{
      return  api.getCountry()
    }

}