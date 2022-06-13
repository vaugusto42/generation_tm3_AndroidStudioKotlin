package com.generation.architecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.generation.architecturecomponents.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //instanciamos o view model provider utilizando a classe MainViewModel
        mainViewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)


        /*
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        assertMainThread("observe");
        if (owner.getLifecycle().getCurrentState() == DESTROYED) {
            // ignore
            return;
        }*/

        //chamamos o .oberve para determinar que o valor inserido no textContador deve manter-se
        // em display ainda que o ciclo de vida e o estado atual da interface seja == DESTROYED
        mainViewModel.cont.observe(this){
            binding.textContador.text = it.toString()
        }

        //binding.textContador.text = mainViewModel.cont.toString()

        //binding.textContador.text = cont.toString()

        binding.buttonClique.setOnClickListener{
            mainViewModel.addNum()
            //binding.textContador.text = mainViewModel.cont.toString()
        }
    }
}
