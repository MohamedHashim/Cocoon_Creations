package com.mohamedhashim.cocoon_creations.mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.mohamedhashim.cocoon_creations.entity.entities.Story
import com.mohamedhashim.cocoon_creations.network.ApiResponse
import com.mohamedhashim.cocoon_creations.network.client.TopStoriesClient
import com.mohamedhashim.cocoon_creations.network.message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
class TopStoriesRepository constructor(
    private val storyClient: TopStoriesClient
) {

    suspend fun loadTopStories(error: (String) -> Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<Story>>()
        var stories = emptyList<Story>()
        storyClient.fetchTopStories { response ->
            when (response) {
                is ApiResponse.Success -> {
                    response.data?.let { data ->
                        stories = data.results
                        liveData.apply { postValue(stories) }
                    }
                }
                is ApiResponse.Failure.Error -> error(response.message())
                is ApiResponse.Failure.Exception -> error(response.message())
            }
        }
        liveData.apply { postValue(stories) }
    }
}