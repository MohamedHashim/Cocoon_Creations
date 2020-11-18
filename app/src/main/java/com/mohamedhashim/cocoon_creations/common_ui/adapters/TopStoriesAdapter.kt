package com.mohamedhashim.cocoon_creations.common_ui.adapters

import android.view.View
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.common_ui.viewholders.TopStoriesViewHolder
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
class TopStoriesAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Story>())
    }

    fun addTopStoriesList(stories: List<Story>) {
        val section = sections()[0]
        section.addAll(stories)
        notifyItemRangeInserted(section.size - stories.size + 1, stories.size)
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_story

    override fun viewHolder(layout: Int, view: View) = TopStoriesViewHolder(view)
}