package com.mohamedhashim.cocoon_creations.common_ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.mohamedhashim.cocoon_creations.entity.entities.Story

/**
 * Created by Mohamed Hashim on 11/20/2020.
 */
class FavouriteStoriesDiffCallback (
    private val oldList: List<Story>,
    private val newList: List<Story>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].title == newList[newItemPosition].title

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        areItemsTheSame(oldItemPosition, newItemPosition)

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size
}
