package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.reactnative.androidsdk.FBSDKPackage;

public class FacebookSdkPlugin {

    private static CallbackManager mCallbackManager = CallbackManager.Factory.create();

    public static CallbackManager getCallbackManager() {
        return mCallbackManager;
    }

    public ReactPackage hook(@NonNull Application application,
                     @NonNull ReactInstanceManagerBuilder reactInstanceManagerBuilder,
                     @NonNull Config config) {
        FacebookSdk.setAutoLogAppEventsEnabled(config.autoLogAppEventsEnabled);
        FacebookSdk.setApplicationId(config.appId);
        FacebookSdk.sdkInitialize(application);
        FBSDKPackage fbsdkPackage = new FBSDKPackage(mCallbackManager);
        reactInstanceManagerBuilder.addPackage(fbsdkPackage);
        return fbsdkPackage;
    }
    public static class Config {
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