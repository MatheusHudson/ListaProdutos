package com.example.listaprodutos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.listaprodutos.Model.Notificacao
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    fun getProdutosLista(): ArrayList<Notificacao> {

        val jsonString = context.assets.open("produtos.json")
            .bufferedReader()
            .use { it.readText() }

        return Gson().fromJson(jsonString, object : TypeToken<ArrayList<Notificacao>>(){}.type)
    }


}