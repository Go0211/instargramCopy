package com.example.android.instargram.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.activity_main_content.*

class MainContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_content)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainBottom, MainBottom())
            .commit()

        mainTopActivity.setOnClickListener {
            val intent = Intent(this@MainContentActivity, MainDoActivity::class.java)
            startActivity(intent)
        }

        mainTopDirect.setOnClickListener {
            val intent = Intent(this@MainContentActivity, MainDirectActivity::class.java)
            startActivity(intent)
        }
    }
}