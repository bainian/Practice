package com.umpay.xingcheng

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.onClick

/**
 * Created by sage on 16-8-30.
 */
class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("oncreate2")
        setContentView(R.layout.activity_main2)
        btn.onClick { startActivity(Intent(this, MainActivity::class.java)) }
        btn2.onClick { startActivity(Intent(this, Activity2::class.java)) }
        btn3.onClick { startActivity(Intent(this, Activity3::class.java)) }
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

    override fun onDestroy() {
        super.onDestroy()
        log("ondestroy2")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        log("onnewIntent2")
    }
}