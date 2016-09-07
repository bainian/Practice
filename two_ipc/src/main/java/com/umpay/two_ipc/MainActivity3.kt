package com.umpay.two_ipc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        println("main 3 id = ${UserManager.id}")
    }
}
