package com.umpay.three_view

import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.IBinder
import android.os.Parcel
import android.util.Log

/**
 * Created by sage on 16-9-1.
 */
class ServerP : Service() {

    override fun onBind(i: Intent?): IBinder? {
        log("onbindService")
        val result = checkCallingOrSelfPermission("com.fnz.permission")
        if (result == PackageManager.PERMISSION_DENIED) {
            log("check permission denied")
            return null;

        } else
            return object : ServerLinstener.Stub() {
                override fun clac(a: Int, b: Int): Int {
                    return a + b + 10
                }

                override fun gotList(name: String?): MutableList<String>? {
                    val arrayListOf = arrayListOf("aa", "bb", "cc")
                    arrayListOf.add(name!!)
                    return arrayListOf
                }



                override fun onTransact(code: Int, data: Parcel?, reply: Parcel?, flags: Int): Boolean {
                    // permission check
                    return super.onTransact(code, data, reply, flags)
                }
            }
    }

    override fun onCreate() {
        super.onCreate()
        log("oncreate")

    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log("onstart command")
        return super.onStartCommand(intent, flags, startId)
    }
}

fun Any.log(msg: String) {
    Log.i(this.javaClass.simpleName, msg)
}