package com.rulerbug.style.Application;

import android.app.Application;

import skin.support.SkinCompatManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinCompatManager.init(this)
                .loadSkin();

    }


}