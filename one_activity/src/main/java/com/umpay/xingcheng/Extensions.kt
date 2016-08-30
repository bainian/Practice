package com.umpay.xingcheng

import android.util.Log

/**
 * Created by sage on 16-8-30.
 */
fun Any.log(msg: String) {
    Log.i(this.javaClass.simpleName, msg)
}