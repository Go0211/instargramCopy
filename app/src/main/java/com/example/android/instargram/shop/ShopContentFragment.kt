package com.example.android.instargram.shop

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.shop_content_fragment.*

class ShopContentFragment : Fragment() {
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

//        val countArrayList = ArrayList<SearchFrame>()
//        for (num in 0..100) {
//            if (num % 2 != 0)
//                countArrayList.add(num, SearchFrame(num))
//            else
//                countArrayList.add(num, SearchFrame(num))
//        }
//
//        searchRecyclerView.adapter = Adapter(countArrayList, LayoutInflater.from(activity))
//        searchRecyclerView.layoutManager = LinearLayoutManager(activity)
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

//1. 버튼들을 스크롤로 볼 수 있게 => Recycler + 스크롤바 정도
//2. 이미지 길게 클릭 시, 짧게 클릭 시를 구별해서 구현
//3. 이미지
//4. 내려가면 동일형태로 데이터를 계속 보여줌 8 + 1=> RecyclerView
//5. 액션바 변경
//6. 새로고침 구현