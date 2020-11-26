package com.example.instagames_ds3m.repository

import com.example.instagames_ds3m.model.GamePost
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class GamePostRepository {

    private val URL = "http://10.0.2.2:8080/api/posts"
    private val OKHTTPCLIENT = OkHttpClient()

    fun getGamePosts() : List<GamePost> {
        // Criar uma requisição GET para o servidor
        val request = Request.Builder().url(URL).get().build()

        // Enviar a requisição para o servidor
        val response = OKHTTPCLIENT.newCall(request).execute()

        // Extrair o body da requisição
        val responseBody = response.body()

        // Transformar o body da resposta em um Json
        val jsonGamePosts = responseBody!!.string()

        // Transformar o Json da resposta em uma lista de objetos GamePost
        val gamePosts = Gson().fromJson(jsonGamePosts, Array<GamePost>::class.java).toList()

        println("************** ${gamePosts.toString()}")

        return gamePosts
    }

}