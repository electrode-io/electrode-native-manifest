package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.react.ReactPackage;
import com.facebook.FacebookSdk;
import com.facebook.reactnative.androidsdk.FBSDKPackage;

public class FacebookSdkPlugin implements ReactPlugin<FacebookSdkPlugin.Config> {

    @Override
    public ReactPackage hook(@NonNull Application application,
                     @NonNull Config config) {
        FacebookSdk.setAutoLogAppEventsEnabled(config.autoLogAppEventsEnabled);
        FacebookSdk.setApplicationId(config.appId);
        FacebookSdk.sdkInitialize(application);
        return new FBSDKPackage();
    }

    public static class Config implements ReactPluginConfig {
        private String appId;
        private boolean autoLogAppEventsEnabled;

        public Config(@NonNull String appId) {
            this.appId = appId;
            this.autoLogAppEventsEnabled = false;
        }

        public Config autoLogAppEventsEnabled(boolean autoLogAppEventsEnabled) {
            this.autoLogAppEventsEnabled = autoLogAppEventsEnabled;
            return this;
        }
    }
}
