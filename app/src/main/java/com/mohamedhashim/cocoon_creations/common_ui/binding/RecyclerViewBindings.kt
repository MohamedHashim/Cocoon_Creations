package com.mohamedhashim.cocoon_creations.common_ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mohamedhashim.cocoon_creations.common_ui.adapters.TopStoriesAdapter
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.whatif.whatIfNotNullOrEmpty

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("adapterTopStoriesList")
fun bindAdapterTopStoriesList(view: RecyclerView, topStories: List<Story>?) {
    topStories.whatIfNotNullOrEmpty {
        val adapter = view.adapter as? TopStoriesAdapter
        adapter?.addTopStoriesList(it)
    }
}
