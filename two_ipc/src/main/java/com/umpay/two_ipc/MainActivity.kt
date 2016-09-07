package com.umpay.two_ipc

import android.content.Intent
import android.os.Bundle
import android.os.Messenger
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UserManager.id = 2
        println("main 1 id = ${UserManager.id}")
        btn1.onClick { startActivity(Intent(this, MainActivity2::class.java)) }

    }
}
