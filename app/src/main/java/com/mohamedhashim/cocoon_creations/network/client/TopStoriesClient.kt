package com.mohamedhashim.cocoon_creations.network.client

import com.mohamedhashim.cocoon_creations.entity.response.TopStoriesResponse
import com.mohamedhashim.cocoon_creations.network.ApiResponse
import com.mohamedhashim.cocoon_creations.network.service.TopStoriesService
import com.mohamedhashim.cocoon_creations.network.transform

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
class TopStoriesClient(private val service: TopStoriesService) {

    fun fetchTopStories(
        onResult: (response: ApiResponse<TopStoriesResponse>) -> Unit
    ) {
        this.service.fetchTopStories().transform(onResult)
    }
}
