package com.umpay.xingcheng

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AlertDialogBuilder
import org.jetbrains.anko.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log("oncreate")
        btn_inter.onClick { }
        //应用程序最大可用内存
        val maxMemory = Runtime.getRuntime().maxMemory().toInt() / 1024 / 1024
        //应用程序已获得内存
        val totalMemory = Runtime.getRuntime().totalMemory().toInt() / 1024 / 1024.toLong()
        //应用程序已获得内存中未使用内存
        val freeMemory = Runtime.getRuntime().freeMemory().toInt() / 1024 / 1024.toLong()
        println("---> maxMemory=" + maxMemory + "M,totalMemory=" + totalMemory + "M,freeMemory=" + freeMemory + "M")

        hw.onClick {
            val builder = AlertDialogBuilder(this)
            val tv = TextView(this)
            tv.text = "jj"
            builder.customView(tv)
            builder.cancellable(false)
//            builder.message("message")
            builder.show()
//            val b = Dialog(this)
//            b.show()
        }
        btn.onClick { startActivity(Intent(this, Activity2::class.java)) }
    }

    override fun onRestart() {
        super.onRestart()
        log("onrestart")
    }

    override fun onStart() {
        super.onStart()
        log("onstart")
    }

    override fun onPause() {
        super.onPause()
        log("onpause")
    }

    override fun onResume() {
        super.onResume()
        log("onresume")

    }

    override fun onStop() {
        super.onStop()
        log("onstop")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("ondestroy")
    }

}
