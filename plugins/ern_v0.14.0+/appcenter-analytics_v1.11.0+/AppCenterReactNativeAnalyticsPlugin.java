package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.microsoft.appcenter.reactnative.analytics.AppCenterReactNativeAnalyticsPackage;

public class AppCenterReactNativeAnalyticsPlugin implements ReactPlugin {

    public ReactPackage hook(@NonNull Application application,
                             @Nullable ReactPluginConfig config) {
        if (config != null && !config.enableInJs.isEmpty()) {
            return new AppCenterReactNativeAnalyticsPackage(application, config.enableInJs);
        }
        return new AppCenterReactNativeAnalyticsPackage(application, config != null ? config.enableDebugMode : false);
    }

    public static class Config implements ReactPluginConfig {
        private boolean enableDebugMode;
        private String enableInJs;

        public Config enableDebugMode(boolean enableDebugMode) {
            this.enableDebugMode = enableDebugMode;
            return this;
        }

        public Config enableInJs(String enableInJs) {
            this.enableInJs = enableInJs;
            return this;
        }
    }
}
