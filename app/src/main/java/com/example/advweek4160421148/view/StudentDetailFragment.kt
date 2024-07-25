package com.example.advweek4160421148.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advweek4160421148.R
import com.example.advweek4160421148.databinding.FragmentStudentDetailBinding
import com.example.advweek4160421148.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment(), ButtonDetailClickListener {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_student_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.listener = this

        arguments?.let {
            val studentId = StudentDetailFragmentArgs.fromBundle(it).studentId
            viewModel.fetch(studentId)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
            student?.let {
                binding.student = it
            }
        })
    }

    override fun onButtonDetailCLick(v: View) {
        // Handle update button click
    }
}