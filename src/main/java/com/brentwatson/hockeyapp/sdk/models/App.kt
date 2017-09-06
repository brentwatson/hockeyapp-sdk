package com.brentwatson.hockeyapp.sdk.models

import com.google.gson.annotations.SerializedName

data class App(
        var title: String,
        @SerializedName("bundle_identifier") var bundleIdentifier: String,
        @SerializedName("public_identifier") var publicIdentifier: String,
        @SerializedName("device_family") var deviceFamily: String?,
        @SerializedName("minimum_os_version") var minimumOsVersion: String,
        @SerializedName("release_type") var releaseType: Long? = null,
        var status: Long? = null,
        var platform: String
)
