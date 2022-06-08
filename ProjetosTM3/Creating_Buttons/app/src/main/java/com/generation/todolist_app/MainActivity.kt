package com.generation.todolist_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Ciclo", "onCreate")

        //referenciamos os componentes que temos no layout
        val buttonNext = findViewById<Button>(R.id.button_Next)

        //configuramos um objeto do tipo intent -  que será a intenção que vai gerar um interação
        val secondIntent = Intent(this, SecondActivity::class.java)

        buttonNext.setOnClickListener{
            startActivity(secondIntent)
        }
    }

    /*override fun onStart() {
        super.onStart()
        setContentView(R.layout.activity_main)
        Log.d("Ciclo", "onStart")
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
        Log.d("Ciclo", "onResume")
    }

    override fun onPause() {
        super.onPause()
        setContentView(R.layout.activity_main)
        Log.d("Ciclo", "onPause")
    }

    override fun onStop() {
        super.onStop()
        setContentView(R.layout.activity_main)
        Log.d("Ciclo", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        setContentView(R.layout.activity_main)
        Log.d("Ciclo", "onRestart")
    }*/

}