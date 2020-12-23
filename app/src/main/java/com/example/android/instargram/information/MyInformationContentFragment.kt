package com.example.android.instargram.information

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.android.instargram.R
import com.example.android.instargram.main.ImageViewPager2Adapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.information_content_fragment.*

class MyInformationContentFragment : Fragment() {
    private lateinit var informationRecyclerViewAdapter: InformationRecyclerViewAdapter
    private lateinit var informationRecyclerView: RecyclerView
    private lateinit var informationRecyclerViewManager: LinearLayoutManager

    private lateinit var informationViewPager2Adapter: InformationViewPager2Adapter
    private lateinit var viewPager: ViewPager2

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
        return inflater.inflate(R.layout.information_content_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ShopPage", "onViewCreated")

        val numCount: ArrayList<InformationData> = ArrayList()
        for (a in 0..100)
            numCount.add(a, InformationData(a))

        informationRecyclerViewAdapter = InformationRecyclerViewAdapter(numCount)
        informationRecyclerViewManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        informationRecyclerView =
            view.findViewById<RecyclerView>(R.id.informationStoryHighlight).apply {
                adapter = informationRecyclerViewAdapter
                layoutManager = informationRecyclerViewManager
        }

        informationViewPager2Adapter = InformationViewPager2Adapter(this)
        viewPager = view.findViewById(R.id.informationViewPager)
        viewPager.adapter = informationViewPager2Adapter
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

//ViewPager2용 어댑터
class InformationViewPager2Adapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 100

    override fun createFragment(position: Int): Fragment {
        val fragment = InformationViewPager2Fragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position+1)
        }

        return fragment
    }
}

private const val ARG_OBJECT = "object"

//ViewPager2에 붙일 Fragment
class InformationViewPager2Fragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_post_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val textView: TextView = view.findViewById(R.id.profilePostView)
            textView.text = getInt(ARG_OBJECT).toString()
//              요거 땜시 에러났어 내일 해결해봐
//            그리고 ㅅㅂ 탭을 왜 fragment에서 못박고 activity에 주니까 지꺼나 인식하고
//            ㅅㅂ새끼들 그럴 수 없지 ㅅㅂ놈들아
//            그러면 activity가 fragment를 인식도 못해
//            fragment에서는 onTouchEvent도 못받아 ㅅㅂ 어캐하라고 하는 거냐 샤발놈들아
//            TabLayoutMediator(
//                informationTabLayout,
//                informationViewPager
//            ) { tab, position ->
//                tab.text = "OBJECT ${(position + 1)}"
//            }.attach()
        }
    }
}

//RecyclerView의 어댑터
class InformationRecyclerViewAdapter(
    val numCount: ArrayList<InformationData>
)
    : RecyclerView.Adapter<InformationRecyclerViewAdapter.InformationViewHolder>() {
    class InformationViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.story_view, parent, false)
        return InformationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return numCount.size
    }

    override fun onBindViewHolder(holder: InformationViewHolder, position: Int) {

    }
}

//RecyclerView의 데이터 클래스
data class InformationData(
    val num: Int
)

//1. 게시물 + 팔로워 + 팔로잉 => 현재 값을 넣는 거 필요
//2. 액션바 편집
//3. ViewPager + fragment 사용
//4. 일단 여기까지