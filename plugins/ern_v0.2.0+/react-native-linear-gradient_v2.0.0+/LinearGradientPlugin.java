package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.BV.LinearGradient.LinearGradientPackage;

public class LinearGradientPlugin {

    public ReactPackage hook(@NonNull Application application,
                     @NonNull ReactInstanceManagerBuilder reactInstanceManagerBuilder) {
        LinearGradientPackage linearGradientPackage = new LinearGradientPackage();
        reactInstanceManagerBuilder.addPackage(linearGradientPackage);
        return linearGradientPackage;
    }
}