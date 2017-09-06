package com.brentwatson.hockeyapp.sdk

import com.brentwatson.hockeyapp.sdk.requests.AppsRequest
import com.brentwatson.hockeyapp.sdk.requests.CrashGroupsRequest
import com.brentwatson.hockeyapp.sdk.requests.CrashesRequest
import com.brentwatson.hockeyapp.sdk.requests.VersionsRequest

class HockeyApp(token: String) {

    companion object {
        var TOKEN : String? = null
    }

    init { TOKEN = token }

    fun apps() = AppsRequest()
    fun versions() = VersionsRequest()
    fun crashGroups() = CrashGroupsRequest()
    fun crashes() = CrashesRequest()
}
