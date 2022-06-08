package com.generation.todolist_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonBack = findViewById<Button>(R.id.button_Back)

        buttonBack.setOnClickListener{
            finish() // usar finish resolve o problema de criação de várias pilhas a partir da segunda activity

        }
    }
}