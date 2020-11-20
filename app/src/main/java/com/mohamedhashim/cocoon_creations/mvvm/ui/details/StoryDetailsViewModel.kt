package com.mohamedhashim.cocoon_creations.mvvm.ui.details

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohamedhashim.cocoon_creations.R
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.mohamedhashim.cocoon_creations.mvvm.repository.TopStoriesRepository

/**
 * Created by Mohamed Hashim on 11/20/2020.
 */
class StoryDetailsViewModel(
    private val topStoriesRepository: TopStoriesRepository
) : ViewModel() {
    val toastLiveData: MutableLiveData<Int> = MutableLiveData()

    fun loadArguments(arguments: Bundle?) {
        if (arguments == null) {
            return
        }
    }

    fun onClickedFavourite(story: Story) {
        if (story.favourite) {
            topStoriesRepository.updateStory(story)
            this.toastLiveData.postValue(R.string.removed_message)
        } else {
            topStoriesRepository.insertStory(story)
            this.toastLiveData.postValue(R.string.added_message)
        }
    }

    fun getUpdatedStory(story: Story) = topStoriesRepository.realStory(story)
}
