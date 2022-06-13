package com.generation.todoapp.api

import com.generation.todoapp.model.Categoria
import okhttp3.Response
import retrofit2.http.GET

interface ApiService {

    @GET("categoria")

    //usamos suspend fun pq iremos apenas rodar essa func dentro de uma corrotina
    suspend fun listCategoria(): retrofit2.Response<List<Categoria>>


}