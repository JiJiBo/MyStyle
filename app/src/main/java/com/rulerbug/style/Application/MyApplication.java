package com.rulerbug.style.Application;

import android.app.Application;
import android.content.Context;

import com.rulerbug.style.Utils.CustomSDCardLoader;

import skin.support.SkinCompatManager;

public class MyApplication extends Application {
    private static Context mc;

    @Override
    public void onCreate() {
        super.onCreate();
        SkinCompatManager.init(this)
                .loadSkin();
        mc = this;
        SkinCompatManager.withoutActivity(this)
                .addStrategy(new CustomSDCardLoader());

    }

    public static Context getContext() {
        return mc;
    }

}