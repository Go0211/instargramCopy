package com.example.android.instargram.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.instargram.R
import kotlinx.android.synthetic.main.main_content_fragment.*

class MainContentFragment : Fragment() {
    private lateinit var storyRecyclerView: RecyclerView
    private lateinit var storyViewAdapter: RecyclerView.Adapter<*>
    private lateinit var storyViewManager: RecyclerView.LayoutManager

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

        val story: ArrayList<Story> = ArrayList()

        for (a in 0..100)
            story.add(a, Story("$a"))

        storyViewManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        storyViewAdapter = StoryAdapter(story)

        storyRecyclerView = view.findViewById<RecyclerView>(R.id.storyRecyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            layoutManager = storyViewManager
            adapter = storyViewAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("DefaultPage", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("DefaultPage", "onStart")
    }

    @SuppressLint("ResourceAsColor")
    override fun onResume() {
        super.onResume()
        Log.d("DefaultPage", "onResume")

        var heartCount: Int = 0
        var collectionCount: Int = 0

        mainContentSwipeRefreshLayout.setOnRefreshListener {
            mainContentSwipeRefreshLayout.isRefreshing = false
        }

        mainMiddleHeart.setOnClickListener {
            if (heartCount == 0) {
                mainMiddleHeart.setBackgroundResource(R.color.heartClick)
                heartCount = 1
                Log.d("HeartClick", "on")
            }
            else {
                mainMiddleHeart.setBackgroundResource(R.color.normalColor)
                heartCount = 0
                Log.d("HeartClick", "off")
            }
        }

        mainMiddleCollection.setOnClickListener {
            if (collectionCount == 0) {
                mainMiddleCollection.setBackgroundResource(R.color.collectionClick)
                collectionCount = 1
                Log.d("CollectionClick", "on")
            }
            else {
                mainMiddleCollection.setBackgroundResource(R.color.normalColor)
                collectionCount = 0
                Log.d("CollectionClick", "off")
            }
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

class StoryAdapter(
    val story: ArrayList<Story>
) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {
    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var text: TextView = view.findViewById(R.id.storyView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return story.size
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.text.text = story[position].storyImage
    }
}


data class Story (
    val storyImage: String
)