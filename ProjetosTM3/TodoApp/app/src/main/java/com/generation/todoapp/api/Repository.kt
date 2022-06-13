package com.generation.todoapp.api

import com.generation.todoapp.model.Categoria
import okhttp3.Response

// vai acessar a variável api para criar a instancia do retrofit e por meio dele acessar os verbos HTTP da classe de serviço
class Repository {

    suspend fun listCategoria(): retrofit2.Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }
}