package com.generation.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.todoapp.adapter.TarefaAdapter
import com.generation.todoapp.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.generation.todoapp.databinding.FragmentListBinding


class ListFragment : Fragment() {

    //
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)



        //
        val listTarefas = listOf(
            Tarefa(
                "Lavar a louça do dia",
                "Lavar a louça",
                "Victor",
                "2022-01-01",
                false,
                "Lipeza da casa"
            ),
            Tarefa(
                "FAZER RAN DAN DAN DAN DAN",
                "lololos",
                "Victor",
                "2022-01-01",
                false,
                "Lipeza da casa"
            ),
            Tarefa(
                "Lavar a louça do dia",
                "Lavar a louça",
                "Victor",
                "2022-01-01",
                false,
                "Lipeza da casa"
            )
        )

        //Configuração do RecyclerView
        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        adapter.setList(listTarefas)

        binding.floatingAdd.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }
}