package com.example.randomfactsapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rakutenassigment.network.NumberFactFetcher
import com.example.randomfactsapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import org.json.JSONObject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    private var factList = ArrayList<String>()
    private lateinit var viewModel: MainViewModel
    private lateinit var  recycleView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val recycleView = view.findViewById<RecyclerView>(R.id.facts_recycleView)
        recycleView.layoutManager = LinearLayoutManager(activity)

        viewModel.numberFacts.observe(requireActivity()) {
            recycleView.adapter = FactsRecycleAdapter(it)
        }

        return view
    }


}