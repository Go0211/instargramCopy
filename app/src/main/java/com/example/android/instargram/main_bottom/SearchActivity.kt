package com.example.android.instargram.main_bottom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.activity_main_direct.*
import kotlinx.android.synthetic.main.activity_search.*
import java.util.zip.Inflater

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        
        val countArrayList = ArrayList<SearchFrame>()
        for (num in 0..100) {
            if (num % 2 != 0)
                countArrayList.add(num, SearchFrame(num))
            else
                countArrayList.add(num, SearchFrame(num))
        }

        searchRecyclerView.adapter = Adapter(countArrayList, LayoutInflater.from(this))
        searchRecyclerView.layoutManager = LinearLayoutManager(this)

        //새로고침 구현
        searchSwipeRefreshLayout.setOnRefreshListener {
            test()
            searchSwipeRefreshLayout.isRefreshing = false
        }
    }

    fun test() {
        Log.d("test", "Good")
    }
}

class Adapter(
    val countArrayList: ArrayList<SearchFrame>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<Adapter.SearchSetting>() {
    class SearchSetting(view: View): RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSetting {
        val view = inflater.inflate(R.layout.searchview, parent, false)
        return SearchSetting(view)
    }

    override fun getItemCount(): Int {
        return countArrayList.size
    }

    override fun onBindViewHolder(holder: SearchSetting, position: Int) {

    }

}

class SearchFrame (
    val num: Int
)
//1. 레이아웃 안 잘리게 수정하기
//2. 이미지 길게 클릭 시, 짧게 클릭 시를 구별해서 구현 
//3. 이미지 + 동영상 삽입
//4. 내려가면 동일형태로 데이터를 계속 보여줌 => RecyclerView
//5. Qr코드