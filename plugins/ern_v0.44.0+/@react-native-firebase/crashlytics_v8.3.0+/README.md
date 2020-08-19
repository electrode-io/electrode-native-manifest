# Prerequisites

- Make sure that you have added `@react-native-firebase/app` to your MiniApp.
- Make sure you have been through [@react-native-firebase/app prerequisites](../app_v8.3.0+/README.md)

You can refer to [React Native Firebase Crashlytics documentation](https://rnfirebase.io/crashlytics/usage#usage) for usage.

## Android

- Follow official Firebase Crashlytics [Android setup instructions](https://rnfirebase.io/crashlytics/android-setup)

## iOS

- In XCode, go to your application project `Build Phases` and add a new `Run Script` phase.
As for the script itself, it should just execute the `run` executable from `FirebaseCrashlytics` that can be found in the `Pods/FirebaseCrashlytics` directory of the container. So this script phase should be a one liner, such as `./<path-to-container>/pods/FirebaseCrashlytics/run`.


