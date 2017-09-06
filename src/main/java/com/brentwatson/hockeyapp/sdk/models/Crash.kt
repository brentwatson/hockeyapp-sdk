package com.brentwatson.hockeyapp.sdk.models

import com.google.gson.annotations.SerializedName

data class Crash(
        val id: Long,
        @SerializedName("app_id") val appId: Long,
        @SerializedName("crash_reason_id") val crashReasonId: Long,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("updated_at") val updatedAt: String,
        val oem: String?,
        val model: String?,
        @SerializedName("os_version") val osVersion: String?,
        @SerializedName("jail_break") val jailBreak: String?,
        @SerializedName("contact_string") val contactString: String?,
        @SerializedName("user_string") val userString: String?,
        @SerializedName("has_log") val hasLog: Boolean,
        @SerializedName("has_description") val hasDescription: Boolean,
        @SerializedName("app_version_id") val appVersionId: Int,
        @SerializedName("bundle_version") val bundleVersion: String?,
        @SerializedName("bundle_short_version") val bundleShortVersion: String?
)
