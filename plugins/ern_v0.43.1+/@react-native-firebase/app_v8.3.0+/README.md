**Android only - iOS in progress**

## Prerequisites

- Follow official Firebase [Android setup instructions](https://rnfirebase.io/#2-android-setup)
- Add the following dependency to the dependencies of your `app/build.gradle`:

```
dependencies {
  // ... other dependencies
  implementation platform("com.google.firebase:firebase-bom:25.5.0")
}
```

**If you need to use a different version of com.google.firebase:firebase-bom** you should override this plugin configuration in your own manifest and set the version you wish to use.

**If you need to use a custom firebase.json configuration file content (defaults to {})** you should override this plugin configuration in your own manifest and replace the following with your config:
```
"string": "BuildConfig.FIREBASE_JSON_RAW", "replaceWith": "\"{}\""
```
The `replaceWith` string value here corresponds to the `firebase.json` file (set  to `{}` in this public plugin configuration).

We are aware of the inconvenience of this, working to find a better solution.
