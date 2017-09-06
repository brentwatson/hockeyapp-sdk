package com.brentwatson.hockeyapp.sdk.models

import com.google.gson.annotations.SerializedName

data class CrashGroup(
        val id: Long,
        @SerializedName("app_id") val appId: Long,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("updated_at") val updatedAt: String,
        @SerializedName("last_crash_at") val lastCrashAt: String,
        @SerializedName("app_version_id") val appVersionId: Int,
        @SerializedName("bundle_version") val bundleVersion: String,
        @SerializedName("bundle_short_version") val bundleShortVersion: String,
        @SerializedName("number_of_crashes") val numberOfCrashes: Int,
        @SerializedName("grouping_hash") val groupingHash: String?,
        @SerializedName("grouping_type") val groupingType: Int?,
        val status: Int,
        val reason: String?,
        @SerializedName("exception_type") val exceptionType: String?,
        val fixed: Boolean,
        val method: String?,
        val file: String?,
        @SerializedName("class") val className: String?,
        val line: String?
)
