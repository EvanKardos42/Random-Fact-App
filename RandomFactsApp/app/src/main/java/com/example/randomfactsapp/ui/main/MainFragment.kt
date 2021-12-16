package com.example.randomfactsapp.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.randomfactsapp.R
import com.example.randomfactsapp.data.utils.Status
import com.example.randomfactsapp.ui.MainViewModel
import com.example.randomfactsapp.ui.util.Callback

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var  recycleView:RecyclerView
    private var contextCallback: Callback? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        contextCallback = activity as Callback

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        recycleView = view.findViewById(R.id.facts_recycleView)
        recycleView.layoutManager = LinearLayoutManager(activity)

        viewModel.numberFacts.observe(requireActivity()) {

            when(it.status) {
                Status.LOADING -> {}
                Status.ERROR -> {  Log.d("MAIN_FRAGMENT42",it.message.toString())}
                Status.SUCCESS -> recycleView.adapter = FactsRecycleAdapter(it.data!!,contextCallback)
            }
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        contextCallback = null
    }


}