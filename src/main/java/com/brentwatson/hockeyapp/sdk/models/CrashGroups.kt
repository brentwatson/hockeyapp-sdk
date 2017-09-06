package com.brentwatson.hockeyapp.sdk.models

import com.google.gson.annotations.SerializedName

data class CrashGroups(
        @SerializedName("crash_reasons") val crashGroups: List<CrashGroup>,
        val status: String,
        @SerializedName("current_page") val currentPage: Int,
        @SerializedName("per_page") val perPage: Int,
        @SerializedName("total_entries") val totalEntries: Int,
        @SerializedName("total_pages") val totalPages: Int
)
