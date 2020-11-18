package com.mohamedhashim.cocoon_creations.network.service

import com.mohamedhashim.cocoon_creations.entity.response.TopStoriesResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
interface TopStoriesService {

    @GET("home.json")
    fun fetchTopStories(): Call<TopStoriesResponse>

}