package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.reactlibrary.androidsettings.RNANAndroidSettingsLibraryPackage;

public class RNANAndroidSettingsLibraryPlugin {
    public ReactPackage hook(@NonNull Application application,
                     @NonNull ReactInstanceManagerBuilder reactInstanceManagerBuilder) {
        RNANAndroidSettingsLibraryPackage rnAndroidSetting = new RNANAndroidSettingsLibraryPackage();
        reactInstanceManagerBuilder.addPackage(rnAndroidSetting);
        return rnAndroidSetting;
    }
}
