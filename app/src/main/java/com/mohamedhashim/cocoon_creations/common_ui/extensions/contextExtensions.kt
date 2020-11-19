package com.mohamedhashim.cocoon_creations.common_ui.extensions

import android.content.Context
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.mohamedhashim.cocoon_creations.common_ui.adapters.TopStoriesAdapter
import com.mohamedhashim.cocoon_creations.common_ui.binding.bindAdapterTopStoriesList
import com.mohamedhashim.cocoon_creations.mvvm.ui.top_stories.TopStoriesViewModel

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */

fun Context.toast(message: String) =
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

fun hidActionBar(activity: AppCompatActivity) {
    activity.requestWindowFeature(Window.FEATURE_NO_TITLE)
    activity.supportActionBar!!.hide()
}

fun showTopStories(
    recyclerView: RecyclerView,
    viewModel: TopStoriesViewModel,
    topStoriesAdapter: TopStoriesAdapter
) {
    recyclerView.removeAllViewsInLayout()
    viewModel.topStoriesListLiveData = viewModel.topStoriesListLiveData
    viewModel.topStoriesListLiveData.value?.let {
        topStoriesAdapter.addTopStoriesList(it)
    }
    bindAdapterTopStoriesList(recyclerView, viewModel.topStoriesListLiveData.value)
}