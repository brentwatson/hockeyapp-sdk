package com.brentwatson.hockeyapp.sdk.requests

import com.brentwatson.hockeyapp.sdk.models.CrashGroups
import com.brentwatson.hockeyapp.sdk.utils.RetrofitUtils
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class CrashGroupsRequest {
    private val service by lazy { RetrofitUtils.createService<CrashGroupsService>() }

    fun list(publicIdentifier: String, page: Int, perPage: Int) = service.list(publicIdentifier, page, perPage)

    fun list(publicIdentifier: String, versionId: Long, params: CrashGroupsParams) =
            service.list(
                    publicIdentifier,
                    versionId,
                    params.page,
                    params.perPage,
                    if (params.symbolicated == true) 1 else null,
                    params.sort?.apiVal,
                    params.order?.toString()?.toLowerCase()
            )
}

internal interface CrashGroupsService {
    @GET("apps/{APP_ID}/crash_reasons")
    fun list(
            @Path("APP_ID") publicIdentifier: String,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int
    ): Call<CrashGroups>

    @GET("apps/{APP_ID}/app_versions/{VERSION_ID}/crash_reasons")
    fun list(
            @Path("APP_ID") publicIdentifier: String,
            @Path("VERSION_ID") versionId: Long,
            @Query("page") page: Int,
            @Query("per_page") perPage: Int,
            @Query("symbolicated") symbolicated: Int?,
            @Query("sort") sort: String?,
            @Query("order") order: String?
    ): Call<CrashGroups>
}

data class CrashGroupsParams(
        val page: Int,
        val perPage: Int,
        val symbolicated: Boolean?, // "optional, set to 1 if you only want crashes that have run through the symbolication process"
        val sort: SortBy?,
        val order: SortDirection?
)

enum class SortBy(val apiVal: String) {
    DATE("date"),
    CLASS("class"),
    LAST_CRASH_AT("last_crash_at"),
    NUMBER_OF_CRASHES("number_of_crashes")
}

enum class SortDirection {
    ASC,
    DESC
}