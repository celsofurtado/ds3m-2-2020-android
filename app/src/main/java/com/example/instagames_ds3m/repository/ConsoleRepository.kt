package com.example.instagames_ds3m.repository

import com.example.instagames_ds3m.model.Console
import com.example.instagames_ds3m.model.GamePost
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class ConsoleRepository {

    private val URL = "http://10.0.2.2:8080/api/consoles"
    private val OKHTTPCLIENT = OkHttpClient()

    fun getConsoles() : List<Console> {
        // Criar uma requisição GET para o servidor
        val request = Request.Builder().url(URL).get().build()

        // Enviar a requisição para o servidor
        val response = OKHTTPCLIENT.newCall(request).execute()

        // Extrair o body da requisição
        val responseBody = response.body()

        // Transformar o body da resposta em um Json
        val jsonConsoles = responseBody!!.string()

        // Transformar o JsonConsoles(String) em uma lista de Consoles
        val consoles = Gson().fromJson(jsonConsoles, Array<Console>::class.java).toList()

        return consoles
    }

}