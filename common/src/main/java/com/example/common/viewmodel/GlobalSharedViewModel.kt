package com.example.common.viewmodel

import androidx.lifecycle.ViewModel

class GlobalSharedViewModel : ViewModel() {

    private var counter = 0

    fun doSmth(){
        counter+=1
        println("---GlobalSharedViewModel->$counter")
    }
}