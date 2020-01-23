package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.corbt.keepawake.KCKeepAwakePackage;

public class KeepAwakePlugin {
    public ReactPackage hook(@NonNull Application application,
                     @NonNull ReactInstanceManagerBuilder reactInstanceManagerBuilder) {
        KCKeepAwakePackage keepAwakePackage = new KCKeepAwakePackage();
        reactInstanceManagerBuilder.addPackage(keepAwakePackage);
        return keepAwakePackage;
    }
}
