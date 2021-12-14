package com.example.randomfactsapp.ui.YearFactFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomfactsapp.R
import com.example.randomfactsapp.ui.main.MainViewModel

class YearFactFragment: Fragment() {

    companion object {
        fun newInstance() = YearFactFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


}