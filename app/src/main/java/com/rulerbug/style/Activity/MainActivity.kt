package com.rulerbug.style.Activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.rulerbug.style.R
import com.rulerbug.style.Utils.CustomSDCardLoader
import kotlinx.android.synthetic.main.activity_main.*
import skin.support.SkinCompatManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        change.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.e("128", "加载内存卡")
                //在内存卡并且在CustomSDCardLoader定义的目录下有red.skin文件
                //记得申请内存卡权限
                requestReadSd()
            }

        })
        change2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.e("128", "加载assets")
                //在assets下的skins下有fen.skin文件
                SkinCompatManager.getInstance().loadSkin("fen.skin", SkinCompatManager.SKIN_LOADER_STRATEGY_ASSETS);
            }

        })
        bt_default.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                SkinCompatManager.getInstance().restoreDefaultTheme();
            }
        })
    }

    val REQUEST_CODE = 100
    fun requestReadSd() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // 检查是否有存储和拍照权限
            if (
                    checkSelfPermission(Manifest.permission.READ_PHONE_STATE) === PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) === PackageManager.PERMISSION_GRANTED
            ) {
                //有权限
                SkinCompatManager.getInstance().loadSkin("red.skin", null, CustomSDCardLoader.SKIN_LOADER_STRATEGY_SDCARD);
            } else {
                //没有权限，开始申请
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE), REQUEST_CODE)
            }
        } else {
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                SkinCompatManager.getInstance().loadSkin("red.skin", null, CustomSDCardLoader.SKIN_LOADER_STRATEGY_SDCARD);
            } else {
                Toast.makeText(this, "权限授予失败！", Toast.LENGTH_SHORT).show()
            }
        }
    }
}