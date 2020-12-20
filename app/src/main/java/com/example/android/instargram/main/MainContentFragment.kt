package com.example.android.instargram.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.main_content_fragment.*

class MainContentFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("DefaultPage", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("DefaultPage", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("DefaultPage", "onCreateView")
        return inflater.inflate(R.layout.main_content_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("DefaultPage", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("DefaultPage", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("DefaultPage", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("DefaultPage", "onResume")

        mainContentSwipeRefreshLayout.setOnRefreshListener {
            mainContentSwipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("DefaultPage", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("DefaultPage", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("DefaultPage", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("DefaultPage", "onDetach")
    }
}