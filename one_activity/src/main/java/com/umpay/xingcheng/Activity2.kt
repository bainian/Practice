package com.umpay.xingcheng

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

/**
 * Created by sage on 16-8-30.
 */
class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("oncreate2")
        setContentView(TextView(this))
    }

    override fun onRestart() {
        super.onRestart()
        log("onrestart2")
    }

    override fun onStart() {
        super.onStart()
        log("onstart2")
    }

    override fun onPause() {
        super.onPause()
        log("onpause2")
    }

    override fun onResume() {
        super.onResume()
        log("onresume2")

    }

    override fun onStop() {
        super.onStop()
        log("onstop2")
    }
}