package com.example.android.instargram.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.example.android.instargram.R
import com.example.android.instargram.information.MyInformationContentFragment
import com.example.android.instargram.post.PostActivity
import com.example.android.instargram.search.SearchContentFragment
import com.example.android.instargram.shop.ShopContentFragment
import kotlinx.android.synthetic.main.activity_main_frame.*
import kotlinx.android.synthetic.main.search_view.*

class MainFrameActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_frame)

        Log.d("ClickBottom", "onResume")

        //기본 메인 띄우고 시작
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.insertContent,
                MainContentFragment()
            )
            .commit()

        //현재 뷰 확인 후 조건문으로 동일 뷰 보여지지 않게 하기위한 변수
        var checkNum = 1

        //메인버튼 클릭 시
        mainBottomHomeButton.setOnClickListener {
            if (checkNum == 1)
                Log.d("ClickBottom", "Don't change")
            else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.insertContent,
                        MainContentFragment()
                    )
                    .commit()
                Log.d("ClickBottom", "change1")
            }

            checkNum = 1
        }

        //검색버튼 클릭 시
        mainBottomSearchButton.setOnClickListener {
            if (checkNum == 2)
                Log.d("ClickBottom", "Don't change")
            else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.insertContent,
                        SearchContentFragment()
                    )
                    .commit()
                Log.d("ClickBottom", "change2")
            }

            checkNum = 2
        }

        //게시버튼 클릭 시
        mainBottomPostButton.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)

                startActivity(intent)
                Log.d("ClickBottom", "change3")
        }

        //Shop버튼 클릭 시
        mainBottomShopButton.setOnClickListener {
            if (checkNum == 4)
                Log.d("ClickBottom", "Don't change")
            else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.insertContent,
                        ShopContentFragment()
                    )
                    .commit()
                Log.d("ClickBottom", "change4")
            }

            checkNum = 4
        }

        //내 정보 버튼 클릭 시
        mainBottomMyInformationButton.setOnClickListener {
            if (checkNum == 5)
                Log.d("ClickBottom", "Don't change")
            else {
                supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.insertContent,
                        MyInformationContentFragment()
                    )
                    .commit()
                Log.d("ClickBottom", "change5")
            }

            checkNum = 5
        }
    }

    //메뉴가 무효화되지 않으면 호출x
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d("ActionBar", "createOption")
        menuInflater.inflate(R.menu.main_content_menu, menu)
        return true
    }

    //옵션 메뉴가 화면에 보여질 때 마다 호출
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        Log.d("ActionBar", "prepareOption")
        return super.onPrepareOptionsMenu(menu)
    }

    //메뉴안 아이템 선택 시
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("ActionBar", "select")

        when(item.itemId) {
            R.id.mainTopActivity -> {
                val intent = Intent(this, MainDoActivity::class.java)
                startActivity(intent)
            }
            R.id.mainTopDirect -> {
                val intent = Intent(this, MainDirectActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}