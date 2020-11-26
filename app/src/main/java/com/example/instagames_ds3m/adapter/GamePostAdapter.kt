package com.example.instagames_ds3m.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagames_ds3m.R
import com.example.instagames_ds3m.model.GamePost
import com.example.instagames_ds3m.viewholder.GamePostHolder

class GamePostAdapter : RecyclerView.Adapter<GamePostHolder>() {

    private var gamePostItems = listOf<GamePost>()

    fun updateGamePostsItems(newGamePostItems: List<GamePost>) {
        this.gamePostItems = newGamePostItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamePostHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_layout, parent, false)
        return GamePostHolder(view)
    }

    override fun getItemCount(): Int {
        return gamePostItems.size
    }

    override fun onBindViewHolder(holder: GamePostHolder, position: Int) {
        holder.bind(gamePostItems[position])
    }


}