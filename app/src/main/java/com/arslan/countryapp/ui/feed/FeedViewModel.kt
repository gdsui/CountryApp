package com.arslan.countryapp.ui.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arslan.countryapp.data.remote.CountryApiClient
import com.arslan.countryapp.data.remote.CountryModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {
    private val service=CountryApiClient()
private val disposable=CompositeDisposable()
    val countryList=MutableLiveData<List<CountryModel>>()
    val countryError=MutableLiveData<Boolean>()
    val isLaoding=MutableLiveData<Boolean>()
    fun refreshData(){
        /*val country=CountryModel("kyrgyzstan","Bishkek","Asia","som","","kg")
        val countr2=CountryModel("kyrgyzstan","Bishkek","Asia","som","","kg")
        val countr3=CountryModel("kyrgyzstan","Bishkek","Asia","som","","kg")
        val countr4=CountryModel("kyrgyzstan","Bishkek","Asia","som","","kg")
        val countryList1= arrayListOf(country,countr2,countr3,countr4)
        countryList.value=countryList1
        countryError.value=false
        isLaoding.value=false*/
        getDataFromApi()

    }
    fun getDataFromApi(){
       isLaoding.value=true
        disposable.add(service.getDataFomApi().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :DisposableSingleObserver<List<CountryModel>>(){
            override fun onSuccess(t: List<CountryModel>) {
                countryList.value=t
                countryError.value=false
                isLaoding.value=false
            }

            override fun onError(e: Throwable) {
                isLaoding.value=false
                countryError.value=true
            }

        }))
    }
}