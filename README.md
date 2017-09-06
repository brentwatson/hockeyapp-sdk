# HockeyApp Java/Kotlin SDK

Implementation of the [HockeyApp API](https://github.com/google/gson) endpoints in Kotlin/Java using [Retrofit](https://github.com/square/retrofit) and [GSON](https://github.com/google/gson).


# Setup

Builds can be found on jitpack.

## Gradle

## Maven

# Demo

Start by creating an instance of `HockeyApp` by providing it a HockeyApp [token](https://rink.hockeyapp.net/manage/auth_tokens).
This object contains methods for each endpoint available from the HockeyApp API.

Eg:
`new HockeyApp("-HOCKEYAPP-TOKEN).apps()`.
returns a list of apps.

The return value is a Retrofit [Call](https://square.github.io/retrofit/2.x/retrofit/retrofit2/Call.html) object that can either be `execute()`-ed to make the network request on the current thread, or can be `enqueue()`-d along with a [Callback](https://square.github.io/retrofit/2.x/retrofit/retrofit2/Callback.html) to make the request on a new thread.

## Java Example

```java
HockeyApp hockeyApp = new HockeyApp("-HOCKEYAPP-TOKEN-");

// Get list of apps
Call<Apps> call = hockeyApp.apps().list();
Response<Apps> response = call.execute();
Apps apps = response.body();
App app = apps.getApps().get(0);
System.out.println(app);

// Get versions for a app
Call<Versions> versionsCall = hockeyApp.versions().list(app.getPublicIdentifier());
Response<Versions> versionsResponse = versionsCall.execute();
Versions versions = versionsResponse.body();
Version version = versions.getAppVersions().get(0);
System.out.println(versions);

// Get crash groups for a version
Call<CrashGroups> crashGroupsCall = hockeyApp.crashGroups().list(
        app.getPublicIdentifier(), version.getId(),
        new CrashGroupsParams(1, 100, Boolean.FALSE,
                SortBy.LAST_CRASH_AT, SortDirection.DESC)
);
Response<CrashGroups> crashGroupsResponse = crashGroupsCall.execute();
CrashGroups crashGroups = crashGroupsResponse.body();
CrashGroup crashGroup = crashGroups.getCrashGroups().get(0);
System.out.println(crashGroup);

// Get crashes within a crash group
Call<Crashes> crashesCall = hockeyApp.crashes().list(app.getPublicIdentifier(), crashGroup.getId());
Response<Crashes> crashesResponse = crashesCall.execute();
Crashes crashes = crashesResponse.body();
System.out.println(crashes);
```

## Kotlin Example

```kotlin
val hockeyApp = HockeyApp("-HOCKEYAPP-TOKEN-")

val apps = hockeyApp.apps().list()
        .execute()
        .body()
val app = apps.apps[0].also {
    println(it)
}

val versions = hockeyApp.versions().list(app.publicIdentifier)
        .execute()
        .body()
val version = versions.appVersions[0].also {
    println(it)
}

val crashGroups = hockeyApp.crashGroups().list(
        publicIdentifier = app.publicIdentifier,
        versionId = version.id,
        params = CrashGroupsParams(
                page = 1,
                perPage = 100,
                symbolicated = false,
                sort = SortBy.LAST_CRASH_AT,
                order = SortDirection.DESC
        )
).execute().body()
val crashGroup = crashGroups.crashGroups[0].also {
    println(it)
}

hockeyApp.crashes().list(app.publicIdentifier, crashGroup.id)
        .execute()
        .body()
        .let { crashes ->
            println(crashes)
        }
```

# Limitations

Currently only `GET` endpoints are implemented.  PRs welcome.
