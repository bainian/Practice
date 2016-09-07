package com.umpay.two_ipc

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.onClick

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        println("main 2 id = ${UserManager.id}")
        btn11.onClick { startActivity(Intent(this, MainActivity3::class.java)) }
    }
}
