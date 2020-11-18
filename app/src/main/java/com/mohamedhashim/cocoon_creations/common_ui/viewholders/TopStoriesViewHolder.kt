package com.mohamedhashim.cocoon_creations.common_ui.viewholders

import android.view.View
import androidx.core.view.ViewCompat
import com.mohamedhashim.cocoon_creations.databinding.ItemStoryBinding
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

/**
 * Created by Mohamed Hashim on 11/19/2020.
 */
class TopStoriesViewHolder(view: View) : BaseViewHolder(view) {

    private lateinit var story: Story
    private val binding by bindings<ItemStoryBinding>(view)

    override fun bindData(data: Any) {
        if (data is Story) {
            story = data
            binding.apply {
                ViewCompat.setTransitionName(binding.itemStoryContainer, data.title)
                story = data
                executePendingBindings()
            }
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onLongClick(v: View?): Boolean {
        TODO("Not yet implemented")
    }
}
