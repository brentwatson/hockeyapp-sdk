package com.brentwatson.hockeyapp.sdk.requests

import com.brentwatson.hockeyapp.sdk.models.Apps
import com.brentwatson.hockeyapp.sdk.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.http.GET

class AppsRequest {
    private val service by lazy { RetrofitUtils.createService<AppsService>() }

    fun list() = service.list()

}

internal interface AppsService {
    @GET("apps") fun list(): Call<Apps>
}
