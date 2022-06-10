package com.generation.architecturecomponents

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// extendendo a classe para que ela seja uma view model
class MainViewModel: ViewModel() {

    /*
    By Default a LiveData será composto por valores imutáveis.
    Para reverter esta situação, basta usar o tipo MutableLiveData.
    */


    var cont = MutableLiveData<Int>(0)

    fun addNum(){
        //o ponto ? serve para indicar que o valor não será null
        cont.value = cont.value?.plus(1)
    }
}