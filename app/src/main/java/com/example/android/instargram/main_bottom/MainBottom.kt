package com.example.android.instargram.main_bottom

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.instargram.R
import com.example.android.instargram.main_middle.MainContentActivity
import kotlinx.android.synthetic.main.bottom_main.*

class MainBottom : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("bottomFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("bottomFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("bottomFragment", "onCreateView")
        return inflater.inflate(R.layout.bottom_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("bottomFragment", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("bottomFragment", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("bottomFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("bottomFragment", "onResume")

        //1. 현재 뷰 확인 후 조건문으로 동일 뷰 보여지지 않게 하기

        //메인버튼 클릭 시
        mainBottomHomeButton.setOnClickListener {
            val intent = Intent(activity, MainContentActivity::class.java)
            startActivity(intent)
        }

        //검색버튼 클릭 시
        mainBottomSearchButton.setOnClickListener {
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        //게시버튼 클릭 시
        mainBottomPostButton.setOnClickListener {
            val intent = Intent(activity, PostActivity::class.java)
            startActivity(intent)
        }

        //Shop버튼 클릭 시
        mainBottomShopButton.setOnClickListener {
            val intent = Intent(activity, ShopActivity::class.java)
            startActivity(intent)
        }

        //내 정보 버튼 클릭 시
        mainBottomMyInformationButton.setOnClickListener {
            val intent = Intent(activity, MyInformationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("bottomFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("bottomFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("bottomFragment", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("bottomFragment", "onDetach")
    }

}