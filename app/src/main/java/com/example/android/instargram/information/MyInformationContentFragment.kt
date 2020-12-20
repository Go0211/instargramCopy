package com.example.android.instargram.information

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.instargram.R

class MyInformationContentFragment : Fragment() {
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

//1. 게시물 + 팔로워 + 팔로잉 => 현재 값을 넣는 거 필요
//2. 액션바 편집
//3. ViewPager + fragment 사용
//4. 일단 여기까지