package com.rulerbug.style.Activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.rulerbug.style.R
import kotlinx.android.synthetic.main.activity_main.*
import skin.support.SkinCompatManager
import skin.support.app.SkinCompatActivity


class MainActivity : SkinCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        change.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.e("1123", "换肤")
                SkinCompatManager.getInstance().loadSkin("fen.skin");
            }

        })
        bt_default.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                SkinCompatManager.getInstance().restoreDefaultTheme();
            }
        })
    }
}