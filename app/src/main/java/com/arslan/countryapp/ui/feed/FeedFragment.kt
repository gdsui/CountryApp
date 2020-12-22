package com.arslan.countryapp.ui.feed

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arslan.countryapp.R
import com.arslan.countryapp.adapter.CountryAdapter
import kotlinx.android.synthetic.main.feed_fragment.*

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private lateinit var viewModel: FeedViewModel

    val countryAdapter=CountryAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feed_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.refreshData()
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=countryAdapter
        swipeRefresh.setOnRefreshListener {
            recyclerView.visibility=View.GONE
            tv_feed_error_text.visibility=View.GONE
            progress_feed.visibility=View.VISIBLE
            viewModel.refreshData()
            swipeRefresh.isRefreshing=false

        }
        viewModel.countryList.observe(viewLifecycleOwner, Observer {
            it?.let {
                recyclerView.visibility=View.VISIBLE
                countryAdapter.updateData(it)
            }
        })
        viewModel.isLaoding.observe(viewLifecycleOwner, Observer {
         it?.let {
             if (it){
                 progress_feed.visibility=View.VISIBLE
             }else{
                 progress_feed.visibility=View.GONE
             }
         }
        })
        viewModel.countryError.observe(viewLifecycleOwner, Observer {
        it?.let {
            if (it){
                tv_feed_error_text.visibility=View.VISIBLE
            }else{
               tv_feed_error_text.visibility=View.GONE
            }
        }
        })
    }

}