package com.arslan.countryapp.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.arslan.countryapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

fun CircleImageView.downloadImage(url:String?,placeholderProgressbar:CircularProgressDrawable){
    val options=RequestOptions().placeholder(placeholderProgressbar).error(R.mipmap.ic_launcher_round)
Glide.with(context)
    .setDefaultRequestOptions(options)
    .load(url)
    .into(this)
}
fun placeHolderProgressBar(context:Context):CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth=8f
        centerRadius=40f
        start()
    }
}