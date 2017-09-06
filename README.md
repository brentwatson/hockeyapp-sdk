# HockeyApp SDK

Implementation of the [HockeyApp API](https://github.com/google/gson) endpoints in Kotlin/Java using [Retrofit](https://github.com/square/retrofit) and [GSON](https://github.com/google/gson).


# Setup

## Gradle

## Maven

# Demo

## Java

```java
final HockeyApp hockeyApp = new HockeyApp("-HOCKEYAPP-TOKEN-");

final Call<Apps> call = hockeyApp.apps().list();
final Response<Apps> response = call.execute();
final Apps apps = response.body();
final App app = apps.getApps().get(0);
System.out.println(app);

final Call<Versions> versionsCall = hockeyApp.versions().list(app.getPublicIdentifier());
final Response<Versions> versionsResponse = versionsCall.execute();
final Versions versions = versionsResponse.body();
final Version version = versions.getAppVersions().get(0);
System.out.println(versions);

final Call<CrashGroups> crashGroupsCall = hockeyApp.crashGroups().list(
        app.getPublicIdentifier(), version.getId(),
        new CrashGroupsParams(1, 100, Boolean.FALSE,
                SortBy.LAST_CRASH_AT, SortDirection.DESC)
);
final Response<CrashGroups> crashGroupsResponse = crashGroupsCall.execute();
final CrashGroups crashGroups = crashGroupsResponse.body();
final CrashGroup crashGroup = crashGroups.getCrashGroups().get(0);
System.out.println(crashGroup);

final Call<Crashes> crashesCall = hockeyApp.crashes().list(app.getPublicIdentifier(), crashGroup.getId());
final Response<Crashes> crashesResponse = crashesCall.execute();
final Crashes crashes = crashesResponse.body();
System.out.println(crashes);
```

## Kotlin

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
