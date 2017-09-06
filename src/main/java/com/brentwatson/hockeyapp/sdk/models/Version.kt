package com.brentwatson.hockeyapp.sdk.models

import com.google.gson.annotations.SerializedName

data class Version (
        val version: String,
        val shortversion: String,
        val title: String,
        val timestamp: Long,
        val appsize: Int,
        val notes: String?,
        val mandatory: Boolean,
        val external: Boolean,
        val device_family: String?,
        val id: Long,
        @SerializedName("app_id") val appId: Long,
        @SerializedName("minimum_os_version") val minimumOsVersion: String?,
        @SerializedName("config_url") val configUrl: String,
        @SerializedName("restricted_to_tags") val restrictedToTags: Boolean,
        val status: Int,
        val tags: List<String>,
        @SerializedName("expired_at") val expiredAt: String?,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("updated_at") val updatedAt: String,
        @SerializedName("sdk_version") val sdkVersion: String?,
        @SerializedName("block_crashes") val blockCrashes: Boolean,
        val app_owner: String
)
