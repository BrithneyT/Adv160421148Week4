package com.example.advweek4160421148.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4160421148.R
import com.example.advweek4160421148.databinding.StudentListItemBinding
import com.example.advweek4160421148.model.Student

class StudentListAdapter(val studentList: ArrayList<Student>) :
    RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener {

    class StudentViewHolder(val view: StudentListItemBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(
            inflater,
            R.layout.student_list_item, parent, false
        )
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studentList[position]
        holder.view.listener = this
        holder.view.btnDetail.tag = studentList[position].id
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailCLick(v: View) {
        val studentId = v.tag.toString()
        val action = StudentListFragmentDirections.actionStudentDetail(studentId)
        Navigation.findNavController(v).navigate(action)
    }
}
