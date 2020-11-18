package com.mohamedhashim.cocoon_creations.mvvm.ui.top_stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.mohamedhashim.cocoon_creations.mvvm.base.LiveCoroutinesViewModel
import com.mohamedhashim.cocoon_creations.mvvm.repository.TopStoriesRepository

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
class TopStoriesViewModel constructor(
    private val topStoriesRepository: TopStoriesRepository
) : LiveCoroutinesViewModel() {

    val storyListLiveData: LiveData<List<Story>>
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {

        this.storyListLiveData =
            launchOnViewModelScope {
                this.topStoriesRepository.loadTopStories { this.toastLiveData.postValue(it) }
            }
    }
}
