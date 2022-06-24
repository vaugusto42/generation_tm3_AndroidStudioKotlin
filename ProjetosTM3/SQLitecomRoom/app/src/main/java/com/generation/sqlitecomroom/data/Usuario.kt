package com.generation.sqlitecomroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")

// usando a notação Entity determinamos que a classe usuario será uma tabela
class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var nome: String,
    var idade: Int
) {
}