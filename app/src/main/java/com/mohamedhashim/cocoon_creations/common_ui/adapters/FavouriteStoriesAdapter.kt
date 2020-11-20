package com.mohamedhashim.cocoon_creations.common_ui.adapters

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.common_ui.viewholders.TopStoriesViewHolder
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

/**
 * Created by Mohamed Hashim on 11/20/2020.
 */
class FavouriteStoriesAdapter(
    private val delegate: TopStoriesViewHolder.Delegate
) : BaseAdapter() {

    init {
        addSection(ArrayList<Story>())
    }

    fun addStoryList(stories: List<Story>) {
        val section = sections()[0]
        val callback = FavouriteStoriesDiffCallback(section as List<Story>, stories)
        val result = DiffUtil.calculateDiff(callback)
        section.clear()
        section.addAll(stories)
        result.dispatchUpdatesTo(this)
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_story

    override fun viewHolder(layout: Int, view: View) = TopStoriesViewHolder(view, delegate)
}
