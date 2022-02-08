package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.react.ReactPackage;
import com.microsoft.appcenter.reactnative.crashes.AppCenterReactNativeCrashesPackage;

public class AppCenterReactNativeCrashesPlugin implements ReactPlugin<AppCenterReactNativeCrashesPlugin.Config> {
    public ReactPackage hook(@NonNull Application application, @Nullable Config config) {
        String crashListenerType = config != null ? config.mCrashListenerType : "";
        return new AppCenterReactNativeCrashesPackage(application, crashListenerType);
    }

    public static class Config implements ReactPluginConfig {
        private String mCrashListenerType;

        public Config crashListenerType(String crashListenerType) {
            mCrashListenerType = crashListenerType != null ? crashListenerType : "";
            return this;
        }
    }
}
