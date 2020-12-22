package com.arslan.countryapp.data.remote

import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountry():Single<List<CountryModel>>
}
//