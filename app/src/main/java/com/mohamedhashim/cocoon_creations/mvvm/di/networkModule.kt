package com.mohamedhashim.cocoon_creations.mvvm.di

import com.mohamedhashim.cocoon_creations.network.EndPoint
import com.mohamedhashim.cocoon_creations.network.RequestInterceptor
import com.mohamedhashim.cocoon_creations.network.client.TopStoriesClient
import com.mohamedhashim.cocoon_creations.network.service.TopStoriesService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(EndPoint.NyTimes)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(TopStoriesService::class.java) }

    single { TopStoriesClient(get()) }
}
