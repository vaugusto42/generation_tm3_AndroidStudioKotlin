package com.generation.todoapp

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.todoapp.databinding.FragmentFormBinding
import com.generation.todoapp.databinding.FragmentListBinding
import com.generation.todoapp.fragment.DatePickerFragment
import com.generation.todoapp.fragment.TimerPickerListener
import com.generation.todoapp.model.Categoria
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.NonDisposableHandle.parent
import java.time.LocalDate


class FormFragment() : Fragment(), TimerPickerListener {

    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    constructor(parcel: Parcel) : this() {

    }
    // utilizando o by activityViewModelos indicamos que toda instancia criada da mainview model
    // sobreviverá em todas as telas(activities), ou seja, iniciamos uma viewModel compartilhada

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel.listCategoria()

        mainViewModel.dataSelecionada.value = LocalDate.now()

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
            response -> Log.d("Requisicao", response.body().toString())
            spinnerCategoria(response.body())
        }

        mainViewModel.dataSelecionada.observe(viewLifecycleOwner){
            selectedDate -> binding.editData.setText(selectedDate.toString())
        }

        binding.buttonSalvar.setOnClickListener{
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }

        binding.editData.setOnClickListener{
            DatePickerFragment(this)
                .show(parentFragmentManager,"DatePicker")
        }

        return binding.root
    }


    //interrogação indica que var poderá ser null
    fun spinnerCategoria(listCategoria: List<Categoria>?){
        if(listCategoria != null){
            binding.spinnerCategoria.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listCategoria
                )
        }
    }

    fun writeToParcel(parcel: Parcel, flags: Int) {
    }

    fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FormFragment> {
        override fun createFromParcel(parcel: Parcel): FormFragment {
            return FormFragment(parcel)
        }

        override fun newArray(size: Int): Array<FormFragment?> {
            return arrayOfNulls(size)
        }
    }

    override fun onDateSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }

}