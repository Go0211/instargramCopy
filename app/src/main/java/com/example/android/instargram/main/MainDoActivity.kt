package com.example.android.instargram.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.instargram.ExampleAdapter
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_do.*
import java.util.ArrayList

class MainDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_do)

        val activeDB = ArrayList<ActiveDB>()
        activeDB.add(0, ActiveDB("권은비", "선넘비", "Reader/Vocal"))
        activeDB.add(1, ActiveDB("사쿠라", "김꾸라", "Vocal"))
        activeDB.add(2, ActiveDB("강혜원", "광배", "Vocal"))
        activeDB.add(3, ActiveDB("최예나", "오리", "Vocal"))
        activeDB.add(4, ActiveDB("이채연", "깃털", "Vocal"))
        activeDB.add(5, ActiveDB("김채원", "쌈아치", "Vocal"))
        activeDB.add(6, ActiveDB("김민주", "김민주엔젤", "Vocal"))
        activeDB.add(7, ActiveDB("나코", "나부키야코", "Vocal"))
        activeDB.add(8, ActiveDB("히토미", "빵토미", "Vocal"))
        activeDB.add(9, ActiveDB("조유리", "조구리", "Vocal"))
        activeDB.add(10, ActiveDB("안유진", "댕댕이", "Vocal"))
        activeDB.add(11, ActiveDB("장원영", "막내온탑", "Vocal"))

        mainDoRecyclerView.adapter = MainDoAdapter(activeDB, LayoutInflater.from(this))
        mainDoRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}

class MainDoAdapter (
    private val activeDB: ArrayList<ActiveDB>,
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<MainDoAdapter.Setting1>() {

    class Setting1(view: View) : RecyclerView.ViewHolder(view) {
        val image: TextView = itemView.findViewById(R.id.activityPeopleImage)
        val nickname: TextView = itemView.findViewById(R.id.activityPeopleNickname)
        val active: TextView = itemView.findViewById(R.id.activityPeopleActive)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Setting1 {
        val view = inflater.inflate(R.layout.itemview, parent, false)
        return Setting1(view)
    }

    override fun getItemCount(): Int {
        return activeDB.size
    }

    override fun onBindViewHolder(holder: Setting1, position: Int) {
        holder.image.text = activeDB[position].image
        holder.nickname.text = activeDB[position].nickname
        holder.active.text = activeDB[position].active
    }
}

//DB사용을 아직 못해서 class설정 후 값을 삽입
class ActiveDB(
    val image: String,
    val nickname: String,
    val active: String
)