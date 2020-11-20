package com.mohamedhashim.cocoon_creations.common_ui.binding

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.mohamedhashim.cocoon_creations.mvvm.ui.details.StoryDetailsViewModel

/**
 * Created by Mohamed Hashim on 11/20/2020.
 */
@BindingAdapter("bindFavourite")
fun bindFavourite(imageView: ImageView, favourite: Boolean) {
    if (favourite) {
        imageView.setImageDrawable(
            ContextCompat.getDrawable(
                imageView.context,
                R.drawable.ic_bookmark
            )
        )
    } else {
        imageView.setImageDrawable(
            ContextCompat.getDrawable(imageView.context, R.drawable.ic_favourite)
        )
    }
}

@BindingAdapter("observeFavourite")
fun observeFavourite(imageView: ImageView, favourite: Boolean) {
    bindFavourite(imageView, favourite)
}

@BindingAdapter("clickListener", "updateDB")
fun clickListener(imageView: ImageView, story: Story, viewModel: StoryDetailsViewModel) {
    imageView.setOnClickListener {
        bindFavourite(imageView, !story.favourite)
        viewModel.onClickedFavourite(story)
    }
}