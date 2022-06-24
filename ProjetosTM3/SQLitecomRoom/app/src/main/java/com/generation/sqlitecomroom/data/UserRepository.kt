package com.generation.sqlitecomroom.data

//Processar as requisições do DAO
class UserRepository(
    private val userDao: UserDAO
    ) {

    val selectUsers = userDao.selectUsers()

    fun addUser(usuario: Usuario){
        userDao.addUser(usuario)
    }
}