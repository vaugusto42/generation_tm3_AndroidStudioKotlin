package com.generation.todoapp.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.todoapp.MainViewModel
import com.generation.todoapp.databinding.CardLayoutBinding
import com.generation.todoapp.model.Tarefa

class TarefaAdapter (
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel,//atualização dinâmica
    val context: Context
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

        //a partir do momento que mudarmos o switch mudamos o andamento da tarefa através da nossa lista
        holder.binding.switchAtivo
            .setOnCheckedChangeListener { compoundButton, ativo ->
                tarefa.status = ativo
                mainViewModel.updateTarefa(tarefa)
            }

        holder.binding.buttonDeletar.setOnClickListener {
            //mainViewModel.deleteTarefa(tarefa.id)
            showAlertDialog(tarefa.id)
        }
    }

    //retorna quantas vezes os nossos componentes serão gerados e quantas vezes as funções serão acessadas
    override fun getItemCount(): Int {
       return listTarefa.size
    }

    fun setList(list: List<Tarefa>){

        listTarefa = list.sortedBy { it.id }
        notifyDataSetChanged()
    }

    //diálogo de alerta pré delete
    private fun showAlertDialog(id: Long){
        AlertDialog.Builder(context)
            .setTitle("Excluir Tarefa")
            .setMessage("Deseja Excluir a Tarefa?")
            .setPositiveButton("Sim"){
                _,_ -> mainViewModel.deleteTarefa(id)
            }
            .setNegativeButton("Não"){
                _,_ ->
            }.show()
    }

}