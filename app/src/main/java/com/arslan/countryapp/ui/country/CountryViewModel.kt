package com.arslan.countryapp.ui.country

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arslan.countryapp.data.remote.CountryModel

class CountryViewModel : ViewModel() {
    val countryLifeData=MutableLiveData<CountryModel>()

    fun getDataFromRoom(){
        val country=CountryModel("kyrgyzstan","Bishkek","Asia","som","","kg")
    }
}