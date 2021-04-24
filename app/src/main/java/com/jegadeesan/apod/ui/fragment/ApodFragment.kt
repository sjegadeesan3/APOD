package com.jegadeesan.apod.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jegadeesan.apod.R
import com.jegadeesan.apod.databinding.FragmentFirstBinding
import com.jegadeesan.apod.domain.usecase.GetApodByDateUseCase
import com.jegadeesan.apod.ui.viewmodel.ApodViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApodFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding
    private val apodViewModel: ApodViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apodViewModel.test()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}