package com.generation.rollingthedices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class secondActivity_selector : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selector_secondpage)

        val buttonDice6 = findViewById<ImageView>(R.id.buttonDice6)
        val buttonDice12 = findViewById<ImageView>(R.id.buttonDice12)
        val buttonDice20 = findViewById<ImageView>(R.id.buttonDice20)

        val thirdIntent = Intent(this, thirdActivity_rollingDice6::class.java)
        val forthIntent = Intent(this, thirdActivity_rollingDice12::class.java)
        val fifthIntent = Intent(this, thirdActivity_rollingDice20::class.java)

        buttonDice6.setOnClickListener{
            startActivity(thirdIntent)
        }

        buttonDice12.setOnClickListener{
            startActivity(forthIntent)
        }

        buttonDice20.setOnClickListener{
            startActivity(fifthIntent)
        }
    }
}