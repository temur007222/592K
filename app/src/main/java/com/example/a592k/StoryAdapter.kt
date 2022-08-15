package com.example.a592k

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

     var ADDSTORY = 0
    var STORY = 1

    override fun getItemViewType(position: Int): Int {
        if (isHeader(position))
            return ADDSTORY
        return STORY
    }

    private fun isHeader(position: Int): Boolean {
        return position == 0
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ADDSTORY) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
            return CreateViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post1, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is CreateViewHolder){

        }

        if (holder is StoryViewHolder) {
            val iv_background = holder.iv_background
            val iv_profile = holder.iv_profile
            val tv_fullname = holder.tv_fullname

            iv_background.setImageResource(story.photo)
            iv_profile.setImageResource(story.profile)
            tv_fullname.text = story.text
        }
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_background: ImageView = view.findViewById(R.id.iv_photo)
        var iv_profile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        var tv_fullname: TextView = view.findViewById(R.id.tv_fullname)
    }

    class CreateViewHolder(view: View):RecyclerView.ViewHolder(view)

}