package com.example.randomfactsapp.ui.yearfact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomfactsapp.R
import com.example.randomfactsapp.data.model.YearFactModel
import com.example.randomfactsapp.data.utils.Status
import com.example.randomfactsapp.ui.MainViewModel

class FactYearFragment: Fragment() {

    companion object {
        fun newInstance() = FactYearFragment()
        const val BUNDLE_KEY = "INDEX_KEY"
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var yearFact:YearFactModel
    private lateinit var dateTitleTextView:TextView
    private lateinit var factTextView:TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fact_year_fragment, container, false)
        dateTitleTextView = view.findViewById(R.id.date_year_textView)
        factTextView = view.findViewById(R.id.year_fact_textView)
        progressBar = view.findViewById(R.id.year_fact_progressBar)
        val number = requireArguments().getInt(BUNDLE_KEY)

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        viewModel.setYearFact(number)


        viewModel.yearFact.observe(requireActivity()) {
            when(it.status) {
                Status.LOADING -> { loadingView() }
                Status.ERROR -> {  Log.d("YEAR_FACT_FRAGMENT42",it.message.toString()) }
                Status.SUCCESS -> {
                    yearFact = it.data!!
                    initView()
                }
            }
        }

        return view
    }

    private fun initView(){
        var title = ""

        title = if(yearFact.date != null ){
            yearFact.date + ","+ yearFact.number
        }else{
            "Year " + yearFact.number
        }
        dateTitleTextView.text = title
        factTextView.text = yearFact.text
        dateTitleTextView.visibility = View.VISIBLE
        factTextView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }
    private fun loadingView(){
        dateTitleTextView.visibility = View.GONE
        factTextView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

}