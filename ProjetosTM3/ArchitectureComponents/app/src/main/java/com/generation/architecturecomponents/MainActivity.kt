package com.generation.architecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.generation.architecturecomponents.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding = ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var cont = 0

        binding.buttonClique.setOnClickListener{
            cont ++
            binding.textCounter.text = cont.toString()
        }
    }
}