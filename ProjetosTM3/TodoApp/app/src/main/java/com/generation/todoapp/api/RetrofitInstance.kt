package com.generation.todoapp.api

import com.generation.todoapp.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // lazy = inicializar essas variáveis toda vez que a gente for conseguir utilizar esse objeto
    // e deixar os objetos disponíveis quando quisermos utilizá-los

    //qual a diferença entre uma lateinit var e uma val by lazy???

    private val retrofit by lazy{
        Retrofit.Builder()
            //precisamos criar o pacote de Constantes para guardar a base URL e não corrermos o risco de mudarmos a URL por acidente
            .baseUrl(Constants.BASE_URL)
            //PARSE JSON TO OBJECT
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //quando usarmos essa variável, ele vai criar a instancia do retrofit com base na ApiService
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}