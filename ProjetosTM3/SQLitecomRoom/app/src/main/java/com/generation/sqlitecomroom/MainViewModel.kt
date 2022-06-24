package com.generation.sqlitecomroom

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.sqlitecomroom.data.UserDatabase
import com.generation.sqlitecomroom.data.UserRepository
import com.generation.sqlitecomroom.data.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (context: Context): ViewModel() {

    val selectUsers: LiveData<List<Usuario>>
    val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(context).userDao()
        repository = UserRepository(userDao)
        selectUsers = repository.selectUsers
    }

    //configurando função com corrotina de inserção de usuários
    // Dispatchers.IO has a unique property of elasticity:
    // its views obtained with CoroutineDispatcher.limitedParallelism are not restricted by the Dispatchers.IO parallelism.
    // Conceptually, there is a dispatcher backed by an unlimited pool of threads, and both Dispatchers.IO
    // and views of Dispatchers.IO are actually views of that dispatcher.
    // In practice this means that, despite not abiding by Dispatchers.IO's parallelism restrictions,
    // its views share threads and resources with it.
    fun addUser(usuario: Usuario){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(usuario)
        }
    }
}