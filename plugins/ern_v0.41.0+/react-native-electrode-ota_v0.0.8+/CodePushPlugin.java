package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.microsoft.codepush.react.CodePush;
import com.microsoft.codepush.react.CodePushBuilder;

public class CodePushPlugin implements ReactPlugin<CodePushPlugin.Config> {
    public ReactPackage hook(@NonNull Application application ,
                     @NonNull Config config) {
       if (config == null) {
           throw new IllegalArgumentException("Config cannot be null");
       }
       CodePush codePush = new CodePushBuilder(config.deploymentKey, application)
            .setIsDebugMode(config.isDebugModeEnabled)
            .setServerUrl(null != config.serverUrl ? config.serverUrl : null)
            .setBundleDiff(null != config.bundleDiff ? config.bundleDiff : null)
            .setBundleFileName(null != config.bundleFileName ? config.bundleFileName : null)
            .build();
        return codePush;
    }

    public static class Config implements ReactPluginConfig {
        private final String deploymentKey;
        private String serverUrl;
        private boolean isDebugModeEnabled;
        private String bundleDiff;
        private String bundleFileName;

        public Config(@NonNull String deploymentKey) {
            this.deploymentKey = deploymentKey;
        }

        public Config serverUrl(String serverUrl) {
            this.serverUrl = serverUrl;
            return this;
        }

        public Config enableDebugMode(boolean isEnabled) {
            this.isDebugModeEnabled = isEnabled;
            return this;
        }

        public Config bundleDiff(String bundleDiff) {
            this.bundleDiff = bundleDiff;
            return this;
        }

        public Config bundleFileName(String bundleFileName) {
            this.bundleFileName = bundleFileName;
            return this;
        }
    }
}
