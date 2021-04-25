package com.jegadeesan.apod.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jegadeesan.apod.R
import com.jegadeesan.apod.databinding.FragmentFirstBinding
import com.jegadeesan.apod.domain.usecase.GetApodByDateUseCase
import com.jegadeesan.apod.ui.adapter.ApodRecyclerView
import com.jegadeesan.apod.ui.viewmodel.ApodViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApodFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding
    private val apodViewModel: ApodViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLatest30DaysApodData()
    }

    private fun getLatest30DaysApodData() {
        apodViewModel.getLatest30DaysApodData().observe(viewLifecycleOwner, { apodList ->
            val layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
            binding?.recyclerView?.layoutManager = layoutManager
            binding?.recyclerView?.adapter = ApodRecyclerView(apodList)
            binding?.recyclerView?.setHasFixedSize(true)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}