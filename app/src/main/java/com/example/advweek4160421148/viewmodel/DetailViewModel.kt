package com.example.advweek4160421148.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advweek4160421148.model.Student

class DetailViewModel : ViewModel() {
    val studentLD = MutableLiveData<Student?>()

    private val studentList = arrayListOf(
        Student("16055","Nonie","1998/03/28","5718444778","https://i.pravatar.cc/150?img=1"),
        Student("13312","Rich","1994/12/14","3925444073","https://i.pravatar.cc/150?img=2"),
        Student("11204","Dinny","1994/10/07","6827808747","https://i.pravatar.cc/150?img=3")
    )

    fun fetch(id: String) {
        val student = studentList.find { it.id == id }
        studentLD.value = student
    }
}