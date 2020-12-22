package com.example.android.instargram.shop

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.shop_content_fragment.*

class ShopContentFragment : Fragment() {
    private lateinit var shopRecyclerView: RecyclerView
    private lateinit var shopRecyclerViewAdapter: ShopRecyclerViewAdapter
    private lateinit var shopLayoutManager: LinearLayoutManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("ShopPage", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ShopPage", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("ShopPage", "onCreateView")
        return inflater.inflate(R.layout.shop_content_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ShopPage", "onViewCreated")

        val countArrayList = ArrayList<ShopFrame>()
        for (num in 0..100) {
            if (num % 2 != 0)
                countArrayList.add(num, ShopFrame(num))
            else
                countArrayList.add(num, ShopFrame(num))
        }

        shopRecyclerViewAdapter = ShopRecyclerViewAdapter(countArrayList)
        shopLayoutManager = LinearLayoutManager(activity)

        shopRecyclerView = view.findViewById<RecyclerView>(R.id.shopRecyclerView).apply{
            adapter = shopRecyclerViewAdapter
            layoutManager = shopLayoutManager
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("ShopPage", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("ShopPage", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ShopPage", "onResume")

        //새로고침
        shopSwipeRefreshLayout.setOnRefreshListener {
            shopSwipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("ShopPage", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ShopPage", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("ShopPage", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("ShopPage", "onDetach")
    }
}

class ShopRecyclerViewAdapter(
    val countArrayList: ArrayList<ShopFrame>
): RecyclerView.Adapter<ShopRecyclerViewAdapter.ShopViewHolder>() {
    class ShopViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shop_view, parent, false)
        return ShopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countArrayList.size
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {

    }
}

data class ShopFrame(
    val shop: Int
)

//1. 버튼들을 스크롤로 볼 수 있게 => Recycler + 스크롤바 정도
//2. 이미지 길게 클릭 시, 짧게 클릭 시를 구별해서 구현
//3. 이미지
//4. 내려가면 동일형태로 데이터를 계속 보여줌 8 + 1=> RecyclerView
//5. 액션바 변경
//6. 새로고침 구현