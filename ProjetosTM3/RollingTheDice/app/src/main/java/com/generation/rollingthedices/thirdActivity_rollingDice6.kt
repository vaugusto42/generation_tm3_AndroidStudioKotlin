package com.generation.rollingthedices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class thirdActivity_rollingDice6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rolling_thirdpage_dice6)

        val buttonRollingDice6 = findViewById<ImageView>(R.id.rolling6)

        buttonRollingDice6.setOnClickListener{
            rollDice(6)
        }

    }

    private fun rollDice(sides: Int){
        val rolling = (1..sides).random()

        val textDice = findViewById<TextView>(R.id.random6)

        textDice.text = rolling.toString()
    }
}