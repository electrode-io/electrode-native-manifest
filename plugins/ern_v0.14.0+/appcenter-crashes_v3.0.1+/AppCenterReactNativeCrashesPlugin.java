package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.microsoft.appcenter.reactnative.crashes.AppCenterReactNativeCrashesPackage;

public class AppCenterReactNativeCrashesPlugin implements ReactPlugin<AppCenterReactNativeCrashesPlugin.Config> {
    public ReactPackage hook(@NonNull Application application,
                             @Nullable Config config) {
        return new AppCenterReactNativeCrashesPackage(application, config != null ? config.automaticCrashDispatchByJs : null);
    }

    public static class Config implements ReactPluginConfig {
        private String automaticCrashDispatchByJs;

        public Config automaticCrashDispatchByJs(String automaticCrashDispatchByJs) {
            this.automaticCrashDispatchByJs = automaticCrashDispatchByJs;
            return this;
        }
    }
}
