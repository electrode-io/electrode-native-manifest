package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.react.ReactPackage;
import com.microsoft.appcenter.reactnative.appcenter.AppCenterReactNativePackage;

public class AppCenterReactNativePlugin implements ReactPlugin {
    public ReactPackage hook(@NonNull Application application, @Nullable ReactPluginConfig config) {
        return new AppCenterReactNativePackage(application);
    }
}
