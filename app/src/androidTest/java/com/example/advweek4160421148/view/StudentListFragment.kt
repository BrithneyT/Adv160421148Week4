package com.example.advweek4160421148.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advweek4160421148.R
import com.example.advweek4160421148.databinding.FragmentStudentListBinding
import com.example.advweek4160421148.viewmodel.ListViewModel


class StudentListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val studentListAdapter  = StudentListAdapter(arrayListOf())
    private lateinit var binding:FragmentStudentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentListBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = studentListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
            studentListAdapter.updateStudentList(it)
        })
    }
}