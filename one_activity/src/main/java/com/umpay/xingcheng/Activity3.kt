package com.umpay.xingcheng

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*
import org.jetbrains.anko.onClick

/**
 * Created by sage on 16-8-31.
 */
class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("oncreate3")
        setContentView(R.layout.activity_main3)
        btn.onClick { startActivity(Intent(this, MainActivity::class.java)) }
        btn4.onClick { startActivity(Intent(this, Activity4::class.java)) }
        btn3.onClick { startActivity(Intent(this, Activity3::class.java)) }
    }

    override fun onRestart() {
        super.onRestart()
        log("onrestart3")
    }

    override fun onStart() {
        super.onStart()
        log("onstart3")
    }

    override fun onPause() {
        super.onPause()
        log("onpause3")
    }

    override fun onResume() {
        super.onResume()
        log("onresume3")

    }

    override fun onStop() {
        super.onStop()
        log("onstop3")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("ondestroy3")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        log("onnewIntent3")
    }
}