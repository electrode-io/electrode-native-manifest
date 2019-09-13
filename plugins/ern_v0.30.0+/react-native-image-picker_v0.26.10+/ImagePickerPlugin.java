package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.react.ReactPackage;
import com.imagepicker.ImagePickerPackage;

public class ImagePickerPlugin implements ReactPlugin<ImagePickerPlugin.Config> {
    public ReactPackage hook(@NonNull Application application,
                      @Nullable Config config) {
        ImagePickerPackage imagepicker = null;
        if(null != config){
          imagepicker = new ImagePickerPackage(config.dialogThemeId);
        } else {
          imagepicker = new ImagePickerPackage();
        }
        return imagepicker;
    }

    public static class Config implements ReactPluginConfig {
        private int dialogThemeId;

        public Config() {
        }

        public Config dialogThemeId(int dialogThemeId) {
            this.dialogThemeId = dialogThemeId;
            return this;
        }
    }
}
