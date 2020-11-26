package com.example.instagames_ds3m.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagames_ds3m.R
import com.example.instagames_ds3m.adapter.GamePostAdapter
import com.example.instagames_ds3m.model.GamePost
import com.example.instagames_ds3m.repository.GamePostRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class HomeFragment : Fragment() {

    private lateinit var recyclerViewGamePosts: RecyclerView
    private val gamePostAdapter = GamePostAdapter()
    private var gamePostsList = listOf<GamePost>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)

        // Instanciar as views/componentes da tela
        recyclerViewGamePosts = view.findViewById(R.id.recycler_view_home)
        recyclerViewGamePosts.layoutManager = LinearLayoutManager(view.context)
        recyclerViewGamePosts.adapter = gamePostAdapter

        // Criar thread de acesso ao WebService (API)
        doAsync {
            gamePostsList = GamePostRepository().getGamePosts()
            uiThread {
                gamePostAdapter.updateGamePostsItems(gamePostsList)
            }
        }

        return view
    }

}