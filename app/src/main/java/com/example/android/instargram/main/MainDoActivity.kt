package com.example.android.instargram.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.instargram.R
import java.util.ArrayList

class MainDoActivity : AppCompatActivity() {
    private lateinit var doRecyclerView: RecyclerView
    private lateinit var doViewAdapter: RecyclerView.Adapter<*>
    private lateinit var doViewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_do)

        Log.d("DoActivity", "onCreate")

        val doDB = ArrayList<DoDB>()
        doDB.add(0, DoDB("권은비", "선넘비", "Reader/Vocal"))
        doDB.add(1, DoDB("사쿠라", "김꾸라", "Vocal"))
        doDB.add(2, DoDB("강혜원", "광배", "Vocal"))
        doDB.add(3, DoDB("최예나", "오리", "Vocal"))
        doDB.add(4, DoDB("이채연", "깃털", "Vocal"))
        doDB.add(5, DoDB("김채원", "쌈아치", "Vocal"))
        doDB.add(6, DoDB("김민주", "김민주엔젤", "Vocal"))
        doDB.add(7, DoDB("나코", "나부키야코", "Vocal"))
        doDB.add(8, DoDB("히토미", "빵토미", "Vocal"))
        doDB.add(9, DoDB("조유리", "조구리", "Vocal"))
        doDB.add(10, DoDB("안유진", "댕댕이", "Vocal"))
        doDB.add(11, DoDB("장원영", "막내온탑", "Vocal"))

        doViewAdapter = DoAdapter(doDB)
        doViewManager = LinearLayoutManager(this@MainDoActivity)

        doRecyclerView = findViewById<RecyclerView>(R.id.DoRecyclerView).apply {
            layoutManager = doViewManager
            adapter = doViewAdapter
        }
    }
}

class DoAdapter(
    val doDB: ArrayList<DoDB>
): RecyclerView.Adapter<DoAdapter.DoViewHolder>(){
    class DoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var textViewImage: TextView = view.findViewById(R.id.activityPeopleImage)
        var textViewNickname: TextView = view.findViewById(R.id.activityPeopleNickname)
        var textViewPeopleActive: TextView = view.findViewById(R.id.activityPeopleActive)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview, parent, false)
        return DoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return doDB.size
    }

    override fun onBindViewHolder(holder: DoViewHolder, position: Int) {
        holder.textViewImage.text = doDB[position].image
        holder.textViewNickname.text = doDB[position].nickname
        holder.textViewPeopleActive.text = doDB[position].active
    }
}

//DB사용을 아직 못해서 class설정 후 값을 삽입
data class DoDB(
    val image: String,
    val nickname: String,
    val active: String
)