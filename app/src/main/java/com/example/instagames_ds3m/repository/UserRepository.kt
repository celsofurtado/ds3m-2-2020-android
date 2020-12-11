package com.example.instagames_ds3m.repository

import android.content.Context
import android.util.Log
import com.example.instagames_ds3m.model.User
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class UserRepository {

    val URL_DATABASE = "http://10.0.2.2:8080/api"

    fun login(user: User, context: Context) : Boolean {

        // Converter o user em Json
        val json = Gson().toJson(user)

        // Header HTTP
        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        // Body da requisição
        val body = RequestBody.create(headerHttp, json)

        // Criar o objeto requisição
        val request = Request.Builder().url("$URL_DATABASE/auth").post(body).build()

        // Enviar a requisição para o servidor
        val okhttpClient = OkHttpClient()
        val response = okhttpClient.newCall(request).execute()

        // Extrair o body da resposta
        val responseBody = response.body()

        // Transformar o responseBody em Json
        val userJson = responseBody!!.string()

        // Transformar o body(json) em um user
        val userLogado = Gson().fromJson(userJson, User::class.java)

        if (userLogado.id != 0L) {
            val sharedPreferences = context.getSharedPreferences("instaGamesProfile", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putLong("userId", userLogado.id)
            editor.putString("userName", userLogado.name)
            editor.putString("userEmail", userLogado.email)
            editor.putString("token", userLogado.token)

            editor.apply()
        }

        return userLogado.id != 0L

    }

}