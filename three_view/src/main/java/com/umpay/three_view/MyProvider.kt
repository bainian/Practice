package com.umpay.three_view

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle

/**
 * Created by sage on 16-9-1.
 * 除了oncreate在主线程运行外,其他crud方法 都 在binder线程池运行
 *
 */
class MyProvider : ContentProvider() {
    override fun insert(p0: Uri?, p1: ContentValues?): Uri? {
        log("insert")
        return null
    }

    override fun query(p0: Uri?, p1: Array<out String>?, p2: String?, p3: Array<out String>?, p4: String?): Cursor? {
        log("query")
        return null
    }


    override fun onCreate(): Boolean {
        log("oncreate")
        return false
    }

    override fun update(p0: Uri?, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        log("update")
        return 0
    }

    override fun delete(p0: Uri?, p1: String?, p2: Array<out String>?): Int {
        log("delete")
        return 0
    }

    /**
     * 返回 uri对应的type,
     */
    override fun getType(p0: Uri?): String {
        return "*/*"
    }

    override fun call(method: String?, arg: String?, extras: Bundle?): Bundle {

        return super.call(method, arg, extras)
    }

}