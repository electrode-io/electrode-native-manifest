# Prerequisites

## Android

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

## iOS

- Mostly follow official Firebase [iOS Setup instructions](https://rnfirebase.io/#3-ios-setup). The only divergence here is with **Configure Firebase with iOS credentials** where you should not put `import <Firebase.h>` in your `AppDelegate.m` as it will automatically come from the container umbrella header.

- In XCode, go to your application project `Build Phases` and add a new `Run Script` phase.
Copy/Paste [this script](https://raw.githubusercontent.com/invertase/react-native-firebase/v6.4.0/packages/app/ios_config.sh) from Firebase. It will take care of parsing your `firebase.json` file *(optional)* to inject its settings in the app plist, during build.
