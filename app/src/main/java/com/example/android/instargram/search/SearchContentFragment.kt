package com.example.android.instargram.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.search_content_fragment.*

class SearchContentFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("SearchPage", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SearchPage", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("SearchPage", "onCreateView")
        return inflater.inflate(R.layout.search_content_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("SearchPage", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("SearchPage", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("SearchPage", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SearchPage", "onResume")

        //새로고침
        searchSwipeRefreshLayout.setOnRefreshListener {
            searchSwipeRefreshLayout.isRefreshing = false
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
        Log.d("SearchPage", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SearchPage", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("SearchPage", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("SearchPage", "onDetach")
    }
}

//class Adapter(
//    val countArrayList: ArrayList<SearchFrame>,
//    val inflater: LayoutInflater
//) : RecyclerView.Adapter<Adapter.SearchSetting>(), Parcelable {
//    class SearchSetting(view: View): RecyclerView.ViewHolder(view) {
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSetting {
//        val view = inflater.inflate(R.layout.search_view, parent, false)
//        return SearchSetting(view)
//    }
//
//    override fun getItemCount(): Int {
//        return countArrayList.size
//    }
//
//    override fun onBindViewHolder(holder: SearchSetting, position: Int) {
//
//    }
//}
//
//class SearchFrame (
//    val num: Int
//)


//1. 레이아웃 안 잘리게 수정하기
//2. 이미지 길게 클릭 시, 짧게 클릭 시를 구별해서 구현
//3. 이미지 + 동영상 삽입
//4. 내려가면 동일형태로 데이터를 계속 보여줌 => RecyclerView
//5. Qr코드
//6. 액션바 변경