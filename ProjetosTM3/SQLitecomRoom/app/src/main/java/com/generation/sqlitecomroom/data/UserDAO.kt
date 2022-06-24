package com.generation.sqlitecomroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)//insere usuários ignorando duplicações
    fun addUser(usuario: Usuario)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun selectUsers(): LiveData<List<Usuario>> //função que retorna uma live data
}