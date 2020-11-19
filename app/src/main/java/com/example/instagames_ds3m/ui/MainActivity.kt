package com.example.instagames_ds3m.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.instagames_ds3m.R
import com.example.instagames_ds3m.repository.GamePostRepository
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonChamarAPI = findViewById<Button>(R.id.button_chamar_api)
        buttonChamarAPI.setOnClickListener {
            val rep = GamePostRepository()
            doAsync {
                rep.getGamePosts()
            }

        }

    }
}