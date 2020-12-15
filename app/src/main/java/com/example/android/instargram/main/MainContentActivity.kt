package com.example.android.instargram.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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
    }
    //메뉴가 무효화되지 않으면 호출x
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("p1", "createOption")
        menuInflater.inflate(R.menu.main_content_menu, menu)
        return true
    }

    //옵션 메뉴가 화면에 보여질 때 마다 호출
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        Log.d("p1", "prepareOption")
        return super.onPrepareOptionsMenu(menu)
    }

    //메뉴안 아이템 선택 시
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("p1", "select")

        when(item.itemId) {
            R.id.mainTopActivity -> {
                val intent = Intent(this@MainContentActivity, MainDoActivity::class.java)
                startActivity(intent)
            }
            R.id.mainTopDirect -> {
                val intent = Intent(this@MainContentActivity, MainDirectActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}