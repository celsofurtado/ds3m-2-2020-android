package com.example.instagames_ds3m.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagames_ds3m.R
import com.example.instagames_ds3m.model.GamePost

class GamePostHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textViewUserName = itemView.findViewById<TextView>(R.id.text_view_user_name)
    private val textViewConsoleMaker = itemView.findViewById<TextView>(R.id.text_view_console_maker)
    private val textViewPostTime = itemView.findViewById<TextView>(R.id.text_view_post_time)
    private val textViewPostTitle = itemView.findViewById<TextView>(R.id.text_view_post_title)
    private val textViewPostText = itemView.findViewById<TextView>(R.id.text_view_post_text)
    private val textViewLikes = itemView.findViewById<TextView>(R.id.text_view_likes)
    private val textViewComments = itemView.findViewById<TextView>(R.id.text_view_comments)

    fun bind(item: GamePost) {
        textViewUserName.text = item.userPostName
        textViewConsoleMaker.text = "${item.consoleName} - ${item.consoleMaker}"
        textViewPostTime.text = item.postTime
        textViewPostTitle.text = item.postTitle
        textViewPostText.text = item.postText
        textViewLikes.text = "${item.totalLikes} curtidas"
        textViewComments.text = "${item.totalComments} comentários"
    }


}