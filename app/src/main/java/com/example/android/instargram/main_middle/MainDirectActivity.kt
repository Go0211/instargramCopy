package com.example.android.instargram.main_middle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.activity_main_direct.*

class MainDirectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_direct)

        val member = ArrayList<Member>()
        member.add(0, Member("권","은","비"))
        member.add(1, Member("사","쿠","라"))
        member.add(2, Member("강","혜","원"))
        member.add(3, Member("최","예","나"))
        member.add(4, Member("이","채","연"))
        member.add(5, Member("김","채","원"))
        member.add(6, Member("나","코","코"))
        member.add(7, Member("김","민","주"))
        member.add(8, Member("히","토","미"))
        member.add(9, Member("조","유","리"))
        member.add(10, Member("안","유","진"))
        member.add(11, Member("장","원","영"))

        MainDirectRecyclerView.adapter = Adapter(member, LayoutInflater.from(this))
        MainDirectRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}

class Adapter(
    private val member: ArrayList<Member>,
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<Adapter.Setting2>() {
    class Setting2(view: View): RecyclerView.ViewHolder(view) {
        val image: TextView = itemView.findViewById(R.id.activityPeopleImage)
        val nickname: TextView = itemView.findViewById(R.id.activityPeopleNickname)
        val active: TextView = itemView.findViewById(R.id.activityPeopleActive)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Setting2 {
        val view = inflater.inflate(R.layout.itemview, parent, false)
        return Setting2(view)
    }

    override fun getItemCount(): Int {
        return member.size
    }

    override fun onBindViewHolder(holder: Setting2, position: Int) {
        holder.image.text = member[position].image
        holder.nickname.text = member[position].nickname
        holder.active.text = member[position].active
    }
}

class Member(
    val image: String,
    val nickname: String,
    val active: String
)