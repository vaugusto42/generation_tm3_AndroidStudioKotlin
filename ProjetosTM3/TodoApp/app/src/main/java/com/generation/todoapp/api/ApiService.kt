package com.generation.todoapp.api

import com.generation.todoapp.model.Categoria
import com.generation.todoapp.model.Tarefa
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @GET("categoria")
    //usamos suspend fun pq iremos apenas rodar essa func dentro de uma corrotina
    suspend fun listCategoria(): retrofit2.Response<List<Categoria>>

    @POST("tarefa")
    suspend fun addTarefa(
        @Body tarefa: Tarefa
    ): retrofit2.Response<Tarefa>

    @GET("tarefa")
    suspend fun listTarefa(): retrofit2.Response<List<Tarefa>>

    @PUT("tarefa")
    suspend fun updateTarefa(
        @Body tarefa: Tarefa
    ): retrofit2.Response<Tarefa>

}