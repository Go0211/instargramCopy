package com.example.android.instargram.search

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
import kotlinx.android.synthetic.main.search_content_fragment.*

class SearchContentFragment : Fragment() {
    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var searchRecyclerViewAdapter: SearchRecyclerViewAdapter
    private lateinit var searchLayoutManager: LinearLayoutManager

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

        val countArrayList = ArrayList<SearchFrame>()
        for (num in 0..100) {
            if (num % 2 != 0)
                countArrayList.add(num, SearchFrame(num))
            else
                countArrayList.add(num, SearchFrame(num))
        }

        searchLayoutManager = LinearLayoutManager(activity)
        searchRecyclerViewAdapter = SearchRecyclerViewAdapter(countArrayList)
        searchRecyclerView = view.findViewById<RecyclerView>(R.id.searchRecyclerView).apply {
            layoutManager = searchLayoutManager
            adapter = searchRecyclerViewAdapter
        }
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

//RecyclerView용 어뎁터
class SearchRecyclerViewAdapter(
    private val countArrayList: ArrayList<SearchFrame>
): RecyclerView.Adapter<SearchRecyclerViewAdapter.SearchViewHolder>() {
    class SearchViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_view, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countArrayList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

    }
}

//RecyclerView용 데이터 클래스
class SearchFrame (
    val layout: Int
)

//2. 이미지 길게 클릭 시, 짧게 클릭 시를 구별해서 구현
//3. 이미지 + 동영상 삽입
//5. Qr코드
//6. 액션바 변경