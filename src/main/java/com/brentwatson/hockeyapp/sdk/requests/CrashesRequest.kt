package com.brentwatson.hockeyapp.sdk.requests

import com.brentwatson.hockeyapp.sdk.models.Crashes
import com.brentwatson.hockeyapp.sdk.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

class CrashesRequest {
    private val service by lazy { RetrofitUtils.createService<CrashesService>() }

    fun list(publicIdentifier: String, crashGroupId: Long) = service.list(publicIdentifier, crashGroupId)

}

internal interface CrashesService {
    @GET("apps/{APP_ID}/crash_reasons/{ID}") fun list(
            @Path("APP_ID") publicIdentifier: String,
            @Path("ID") crashGroupId: Long
    ): Call<Crashes>
}
