package com.example.android.instargram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataSet = ArrayList<DataBaseList>()
        for (a in 0..30) {
            myDataSet.add(DataBaseList("아이즈원  $a 번째", " $a 멤버"))
        }

        recycler_view.adapter = ExampleAdapter(myDataSet, LayoutInflater.from(this))
        recycler_view.layoutManager = LinearLayoutManager(this)
    }
}

class ExampleAdapter(
    val myDataSet: ArrayList<DataBaseList>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<ExampleAdapter.Second>() {
    class Second (Third: View) : RecyclerView.ViewHolder(Third) {
        val a: TextView
        val b: TextView

        init {
            a = itemView.findViewById(R.id.activityPeopleNickname)
            b = itemView.findViewById(R.id.activityPeopleActive)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Second {
        val view = inflater.inflate(R.layout.itemview, parent, false)
        return Second(view)
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }

    override fun onBindViewHolder(holder: Second, position: Int) {
        holder.a.setText(myDataSet.get(position).a)
        holder.b.setText(myDataSet.get(position).b)
    }
}

class DataBaseList(val a: String, val b: String) {

}
