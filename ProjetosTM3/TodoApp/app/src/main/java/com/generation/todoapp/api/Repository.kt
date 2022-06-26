package com.generation.todoapp.api

import com.generation.todoapp.model.Categoria
import com.generation.todoapp.model.Tarefa
import okhttp3.Response

// vai acessar a variável api para criar a instancia do retrofit e por meio dele acessar os verbos
// HTTP da classe de serviço
class Repository {

    suspend fun listCategoria(): retrofit2.Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): retrofit2.Response<Tarefa>{
        return RetrofitInstance.api.addTarefa(tarefa)
    }

    suspend fun listTarefa(): retrofit2.Response<List<Tarefa>>{
        return RetrofitInstance.api.listTarefa()
    }

    suspend fun updateTarefa(tarefa: Tarefa): retrofit2.Response<Tarefa>{
        return RetrofitInstance.api.updateTarefa(tarefa)
    }

}