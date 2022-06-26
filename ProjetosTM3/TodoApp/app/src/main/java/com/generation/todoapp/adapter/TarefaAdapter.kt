package com.generation.todoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.todoapp.MainViewModel
import com.generation.todoapp.databinding.CardLayoutBinding
import com.generation.todoapp.model.Tarefa

class TarefaAdapter (
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel //atualização dinâmica
        ): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>(){

    private var listTarefa = emptyList<Tarefa>()

    class TarefaViewHolder (val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root)


    //cria o card onde as informações estarão
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    //cria os itens e os joga dentro dos componenetes que temos dentro do card
    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listTarefa[position]

        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textResponsavel.text = tarefa.responsavel
        holder.binding.textData.text = tarefa.data
        holder.binding.switchAtivo.isChecked = tarefa.status
        holder.binding.textCategoria.text = tarefa.categoria.descricao

        holder.itemView.setOnClickListener{
            taskClickListener.onTaskClickListener(tarefa) //recuperamos a tarefa dentro do listfragment
        }

    }

    //retorna quantas vezes os nossos componentes serão gerados e quantas vezes as funções serão acessadas
    override fun getItemCount(): Int {
       return listTarefa.size
    }

    fun setList(list: List<Tarefa>){

        listTarefa = list
        notifyDataSetChanged()
    }

}