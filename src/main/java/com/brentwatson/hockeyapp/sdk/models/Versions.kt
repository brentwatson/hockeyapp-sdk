package com.brentwatson.hockeyapp.sdk.models

import com.google.gson.annotations.SerializedName

data class Versions(
        @SerializedName("app_versions") val appVersions: List<Version>,
        val status: String
)