package com.brentwatson.hockeyapp.sdk.requests

import com.brentwatson.hockeyapp.sdk.models.Versions
import com.brentwatson.hockeyapp.sdk.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

class VersionsRequest {
    private val service by lazy { RetrofitUtils.createService<VersionsService>() }

    fun list(publicIdentifier: String) = service.list(publicIdentifier)

}

internal interface VersionsService {
    @GET("apps/{APP_ID}/app_versions")
    fun list(@Path("APP_ID") publicIdentifier: String): Call<Versions>
}
