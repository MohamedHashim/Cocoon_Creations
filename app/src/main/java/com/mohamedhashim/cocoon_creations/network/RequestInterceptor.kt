package com.mohamedhashim.cocoon_creations.network

import com.mohamedhashim.cocoon_creations.BuildConfig
import com.mohamedhashim.cocoon_creations.BuildConfig.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Mohamed Hashim on 11/18/2020.
 */
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        val url = originalUrl.newBuilder()
            .addQueryParameter("api-key", BuildConfig.API_KEY)
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}