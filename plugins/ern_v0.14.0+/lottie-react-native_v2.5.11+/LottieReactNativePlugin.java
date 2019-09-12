package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.airbnb.android.react.lottie.LottiePackage;

public class LottieReactNativePlugin implements ReactPlugin {
    public ReactPackage hook(@NonNull Application application, @Nullable ReactPluginConfig config) {
        return new LottiePackage();
    }
}
