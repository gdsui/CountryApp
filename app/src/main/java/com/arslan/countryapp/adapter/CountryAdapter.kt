package com.arslan.countryapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.arslan.countryapp.R
import com.arslan.countryapp.data.remote.CountryModel
import com.arslan.countryapp.ui.feed.FeedFragmentDirections
import com.arslan.countryapp.utils.downloadImage
import com.arslan.countryapp.utils.placeHolderProgressBar
import kotlinx.android.synthetic.main.list_country.view.*

class CountryAdapter(val countryList:ArrayList<CountryModel>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {


    class CountryViewHolder( val view:View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
      val view= LayoutInflater.from(parent.context).inflate(R.layout.list_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.tv_name_item_country.text= countryList[position].countryName
        holder.view.tv_region_item.text=countryList[position].countryRegion
        holder.view.setOnClickListener {
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }
        holder.view.image_item_country.downloadImage(countryList[position].flag, placeHolderProgressBar(holder.view.context))
    }
    fun updateData( newList:List<CountryModel>){
      countryList.clear()
        countryList.addAll(newList)
        notifyDataSetChanged()
    }
}