## [React Native Gesture Handler](https://github.com/kmagiera/react-native-gesture-handler) plugin.

### Prerequisites
[Electrode Native](https://github.com/electrode-io/electrode-native) >= 0.38.0

### To add this plugion to your miniapp

`ern add react-native-gesture-handler`

## For Android

Create a custom delegate(`ReactNativeGestureDelegate.java`) by extending `ElectrodeReactFragmentActivityDelegate.java` and override the following method.

```java
@Override
protected ReactRootView createRootView() {
    return new RNGestureHandlerEnabledRootView(getContext());
}
```

Then use this delegate in your activity. If your activity is extending `ElectrodeBaseActivity.java` then override the following method as below.

```java
@NonNull
protected ElectrodeReactFragmentActivityDelegate createElectrodeDelegate() {
    return new ReactNativeGestureDelegate(this);
}
```