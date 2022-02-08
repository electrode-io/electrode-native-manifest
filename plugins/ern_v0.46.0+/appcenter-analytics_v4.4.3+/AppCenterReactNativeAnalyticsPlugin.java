package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.react.ReactPackage;
import com.microsoft.appcenter.reactnative.analytics.AppCenterReactNativeAnalyticsPackage;

public class AppCenterReactNativeAnalyticsPlugin implements ReactPlugin<AppCenterReactNativeAnalyticsPlugin.Config> {
    public ReactPackage hook(@NonNull Application application, @Nullable Config config) {
        boolean startEnabled = config != null && config.mStartEnabled;
        return new AppCenterReactNativeAnalyticsPackage(application, startEnabled);
    }

    public static class Config implements ReactPluginConfig {
        private boolean mStartEnabled;

        public Config startEnabled() {
            mStartEnabled = true;
            return this;
        }
    }
}
