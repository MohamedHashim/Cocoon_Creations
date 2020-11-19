package com.mohamedhashim.cocoon_creations.common_ui.binding

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mohamedhashim.cocoon_creations.R

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
@BindingAdapter("bindingPosterUrl")
fun bindingPosterUrl(imageView: ImageView, path: String?) {
    path?.let {
        imageView.clipToOutline = true
        Glide.with(imageView.context)
            .load(path)
            .error(ContextCompat.getDrawable(imageView.context, R.drawable.ic_not_found))
            .into(imageView)
    }
}