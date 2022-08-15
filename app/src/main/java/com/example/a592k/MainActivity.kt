package com.example.a592k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        recyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        refreshAdapter(getAll(),recyclerView)
    }

    private fun refreshAdapter(stories: ArrayList<Feed>, recyclerView: RecyclerView) {
        val adapter = StoryAdapter(this, stories)
        recyclerView.adapter = adapter
    }

    fun getAll(): ArrayList<Feed>{
        val feeds = ArrayList<Feed>()

        feeds.add(Feed(R.drawable.mac, R.drawable.nissan, "Anna"))
        feeds.add(Feed(R.drawable.mac, R.drawable.nissan, "Anna"))
        feeds.add(Feed(R.drawable.mac, R.drawable.nissan, "Anna"))

        return feeds
    }
}