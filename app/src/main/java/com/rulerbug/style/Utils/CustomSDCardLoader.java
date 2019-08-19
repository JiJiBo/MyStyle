package com.rulerbug.style.Utils;

import android.content.Context;

import com.rulerbug.style.domain.Constance;

import java.io.File;

import skin.support.load.SkinSDCardLoader;
import skin.support.utils.SkinFileUtils;

public class CustomSDCardLoader extends SkinSDCardLoader {
    public static final int SKIN_LOADER_STRATEGY_SDCARD = Integer.MAX_VALUE-43242;

    @Override
    protected String getSkinPath(Context context, String skinName) {
        return new File(Constance.ROOOT_PATH, skinName).getAbsolutePath();
    }

    @Override
    public int getType() {
        return SKIN_LOADER_STRATEGY_SDCARD;
    }
}