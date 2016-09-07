package com.umpay.xingcheng

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main4.*
import org.jetbrains.anko.onClick

/**
 * Created by sage on 16-8-41.
 */
class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("oncreate4")
        setContentView(R.layout.activity_main4)
        btn.onClick { startActivity(Intent(this, MainActivity::class.java)) }
        btn4.onClick { startActivity(Intent(this, Activity4::class.java)) }
    }

    override fun onRestart() {
        super.onRestart()
        log("onrestart4")
    }

    override fun onStart() {
        super.onStart()
        log("onstart4")
    }

    override fun onPause() {
        super.onPause()
        log("onpause4")
    }

    override fun onResume() {
        super.onResume()
        log("onresume4")

    }

    override fun onStop() {
        super.onStop()
        log("onstop4")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("ondestroy4")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        log("onnewIntent4")
    }
}