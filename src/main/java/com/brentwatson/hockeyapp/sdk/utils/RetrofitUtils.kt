package com.brentwatson.hockeyapp.sdk.utils

import com.brentwatson.hockeyapp.sdk.Constants
import com.brentwatson.hockeyapp.sdk.HockeyApp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtils {

    val retrofit: Retrofit by lazy {
        val client = OkHttpClient.Builder()
                .addInterceptor({ chain ->
                    chain.request().let { original ->
                        original.newBuilder()
                                .header("X-HockeyAppToken", HockeyApp.TOKEN)
                                .method(original.method(), original.body())
                                .build()
                    }.let { chain.proceed(it) }
                }).build()

        Retrofit.Builder()
                .baseUrl(Constants.HOCKEYAPP_API_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    inline fun <reified T> createService() = retrofit.create(T::class.java) as T
}
