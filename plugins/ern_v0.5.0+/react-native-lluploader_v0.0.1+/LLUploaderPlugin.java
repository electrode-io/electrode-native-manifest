package com.walmartlabs.ern.container.plugins;

import android.app.Application;
import android.support.annotation.NonNull;

import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import net.livelinktechnology.lluploader.LLUploaderPackage;

public class LLUploaderPlugin {

    public ReactPackage hook(@NonNull Application application,
                     @NonNull ReactInstanceManagerBuilder reactInstanceManagerBuilder) {
        LLUploaderPackage llUploaderPackage = new LLUploaderPackage();
        reactInstanceManagerBuilder.addPackage(llUploaderPackage);
        return llUploaderPackage;
    }
}
