package com.example.randomfactsapp.ui.yearfact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomfactsapp.R
import com.example.randomfactsapp.data.model.FactYearModel
import com.example.randomfactsapp.data.utils.Status
import com.example.randomfactsapp.ui.MainViewModel

class FactYearFragment: Fragment() {

    companion object {
        fun newInstance() = FactYearFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var yearFact:FactYearModel
    private lateinit var dateTitleTextView:TextView
    private lateinit var factTextView:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val view = inflater.inflate(R.layout.fact_year_fragment, container, false)

        dateTitleTextView = view.findViewById(R.id.date_year_textView)
        factTextView = view.findViewById(R.id.year_fact_textView)

        viewModel.yearFact.observe(requireActivity()) {
            when(it.status) {
                Status.LOADING -> {}
                Status.ERROR -> {}
                Status.SUCCESS -> {
                    yearFact = it.data!!
                    initView()
                }
            }
        }

        return view
    }

    private fun initView(){
        val title = yearFact.date + "," + yearFact.number
        dateTitleTextView.text = title
        factTextView.text = yearFact.text
    }

}