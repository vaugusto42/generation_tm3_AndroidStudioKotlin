package com.generation.rollingthedices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class thirdActivity_rollingDice20 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rolling_thirdpage_dice20)

        val buttonRollingDice20 = findViewById<ImageView>(R.id.rolling20)

        buttonRollingDice20.setOnClickListener{
            rollDice(20)
        }

    }

    private fun rollDice(sides: Int){
        val rolling = (1..sides).random()

        val textDice = findViewById<TextView>(R.id.textView2)

        textDice.text = rolling.toString()
    }

}