package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import net.livelinktechnology.llimageview.LLImageViewPackage;

public class LLImageViewPlugin {

    public ReactPackage hook(@NonNull Application application,
                     @NonNull ReactInstanceManagerBuilder reactInstanceManagerBuilder) {
        LLImageViewPackage llImageViewPackage = new LLImageViewPackage();
        reactInstanceManagerBuilder.addPackage(llImageViewPackage);
        return llImageViewPackage;
    }
}
