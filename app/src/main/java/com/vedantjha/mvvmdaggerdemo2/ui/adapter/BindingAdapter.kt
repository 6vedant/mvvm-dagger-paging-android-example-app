package com.vedantjha.mvvmdaggerdemo2.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("imageFromUrl", "shouldRound")
fun bindImageFromUrl(view: ImageView, imageUrl: String?, shouldRound: Boolean) {
    if (!imageUrl.isNullOrEmpty()) {
        val glide = Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
        if (shouldRound) glide.transform(CenterCrop(), RoundedCorners(16))
        glide.into(view)

    }
}