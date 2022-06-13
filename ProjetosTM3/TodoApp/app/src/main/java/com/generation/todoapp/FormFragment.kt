package com.generation.todoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.todoapp.databinding.FragmentFormBinding
import com.generation.todoapp.databinding.FragmentListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.NonDisposableHandle.parent


class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    // utilizando o by activityViewModelos indicamos que toda instancia criada da mainview model
    // sobreviverá em todas as telas(activities), ou seja, iniciamos uma viewModel compartilhada

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
            Log.d("Requisicao", it.body().toString())
        }

        binding.buttonSalvar.setOnClickListener{
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }

        return binding.root
    }

}