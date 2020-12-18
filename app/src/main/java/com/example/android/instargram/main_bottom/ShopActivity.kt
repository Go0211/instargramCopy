package com.example.android.instargram.main_bottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.instargram.R

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        //1. 버튼들을 스크롤로 볼 수 있게 => Recycler + 스크롤바 정도
        //2. 이미지 길게 클릭 시, 짧게 클릭 시를 구별해서 구현
        //3. 이미지
        //4. 내려가면 동일형태로 데이터를 계속 보여줌 8 + 1=> RecyclerView
        //5. 액션바 변경
        //6. 새로고침 구현
    }
}