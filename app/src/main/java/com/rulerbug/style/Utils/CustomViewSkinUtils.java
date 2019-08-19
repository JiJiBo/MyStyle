package com.rulerbug.style.Utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomViewSkinUtils {
    /**
     * 因为Android-skin-support的皮肤包是放在assets中的，所以我们这里也从assets中获取皮肤包
     * 并保存在sdk中（这里只是为了兼容Android-skin-support ，其实可以直接把皮肤包放在sdk中的）
     * @param context
     * @param skinName 皮肤包的名称（不包括后缀名）
     */
    public static void copySkinApk(Context context, String skinName) {
        try {
            File dex = new File( Environment.getExternalStorageDirectory().toString() + File.separator + skinName + ".apk" );
            InputStream input = context.getAssets().open( "skins/" + skinName + ".skin" );
            dex.createNewFile();
            FileOutputStream fo = new FileOutputStream( dex );
            int a = 0;
            byte bf[] = new byte[1024];
            while ((a = input.read( bf )) != -1) {
                fo.write( bf, 0, a );
                fo.flush();
            }
            fo.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
