package com.arslan.countryapp.ui.country

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.arslan.countryapp.R
import kotlinx.android.synthetic.main.country_fragment.*
import kotlinx.android.synthetic.main.feed_fragment.*

class CountryFragment : Fragment() {
    companion object {
        fun newInstance() = CountryFragment()
    }

    private lateinit var viewModel: CountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.country_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom()
        viewModel.countryLifeData.observe(viewLifecycleOwner, Observer {
            it?.let {
            tv_country_name.text=it.countryName
                tv_country_capital.text=it.countryCapital
                tv_country_currency.text=it.currency
                tv_country_language.text=it.language
                tv_country_region.text=it.countryRegion
            }
        })

    }

}