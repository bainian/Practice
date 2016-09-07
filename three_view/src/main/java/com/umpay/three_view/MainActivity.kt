package com.umpay.three_view

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick
import java.util.concurrent.CountDownLatch

class MainActivity : AppCompatActivity() {
    lateinit var i: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        log("oncreate connect  service")
        i = Intent(this, ServerP::class.java)
        val tong = CountDownLatch(1)
        bindService(i, remoteService, Context.BIND_AUTO_CREATE)
        tong.await()
        clc.onClick {
            val clac = sl.clac(9, 8)
            println("clc result = $clac")
            val list = sl.gotList("88")
            println("list = $list")
        }
    }

    lateinit var sl: ServerLinstener
    val remoteService = object : android.content.ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {
            log("onServiceDisconnect $p0")
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            log("onSericeConnected $p0")
//            sl = p1 as ServerLinstener
            sl = ServerLinstener.Stub.asInterface(p1)
            p1!!.linkToDeath(IBinder.DeathRecipient {
                log("re start connect service")
                bindService(i, this, Context.BIND_AUTO_CREATE)
            }, 0)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (sl != null) {
            unbindService(remoteService)
        }
    }
}
