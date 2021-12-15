package com.example.randomfactsapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.randomfactsapp.R
import com.example.randomfactsapp.data.utils.Status
import com.example.randomfactsapp.ui.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var  recycleView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        recycleView = view.findViewById<RecyclerView>(R.id.facts_recycleView)
        recycleView.layoutManager = LinearLayoutManager(activity)

        viewModel.numberFacts.observe(requireActivity()) {

            when(it.status) {
                Status.LOADING -> {}
                Status.ERROR -> {}
                Status.SUCCESS -> recycleView.adapter = FactsRecycleAdapter(it.data!!)
            }
        }

        return view
    }


}