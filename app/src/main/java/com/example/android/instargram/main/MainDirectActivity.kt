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
import kotlinx.android.synthetic.main.activity_main_direct.*

class MainDirectActivity : AppCompatActivity() {
    private lateinit var directRecyclerView: RecyclerView
    private lateinit var directViewAdapter: RecyclerView.Adapter<*>
    private lateinit var directViewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_direct)

        Log.d("DirectActivity", "onCreate")

        val directDB = ArrayList<DirectDB>()

        directDB.add(0, DirectDB("권", "은", "비"))
        directDB.add(1, DirectDB("사", "쿠", "라"))
        directDB.add(2, DirectDB("강", "혜", "원"))
        directDB.add(3, DirectDB("최", "예", "나"))
        directDB.add(4, DirectDB("이", "채", "연"))
        directDB.add(5, DirectDB("김", "채", "원"))
        directDB.add(6, DirectDB("나", "코", "코"))
        directDB.add(7, DirectDB("김", "민", "주"))
        directDB.add(8, DirectDB("히", "토", "미"))
        directDB.add(9, DirectDB("조", "유", "리"))
        directDB.add(10, DirectDB("안", "유", "진"))
        directDB.add(11, DirectDB("장", "원", "영"))

        directViewAdapter = DirectAdapter(directDB)
        directViewManager = LinearLayoutManager(this)

        directRecyclerView = findViewById<RecyclerView>(R.id.DirectRecyclerView).apply {
            adapter = directViewAdapter
            layoutManager = directViewManager
        }
    }
}

class DirectAdapter(
    val directDB: ArrayList<DirectDB>
): RecyclerView.Adapter<DirectAdapter.DirectViewHolder>() {
    class DirectViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var textViewImage: TextView = view.findViewById(R.id.activityPeopleImage)
        var textViewNickname: TextView = view.findViewById(R.id.activityPeopleNickname)
        var textViewActive: TextView = view.findViewById(R.id.activityPeopleActive)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview, parent, false)
        return DirectViewHolder(view)
    }

    override fun getItemCount(): Int {
        return directDB.size
    }

    override fun onBindViewHolder(holder: DirectViewHolder, position: Int) {
        holder.textViewImage.text = directDB[position].image
        holder.textViewNickname.text = directDB[position].nickname
        holder.textViewActive.text = directDB[position].active
    }
}

data class DirectDB(
    val image: String,
    val nickname: String,
    val active: String
)