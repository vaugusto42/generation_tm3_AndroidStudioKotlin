package com.generation.rollingthedices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val buttonPlay = findViewById<ImageView>(R.id.play)

        val secondIntent = Intent(this, secondActivity_selector::class.java)

        buttonPlay.setOnClickListener{
            startActivity(secondIntent)
        }
    }
}