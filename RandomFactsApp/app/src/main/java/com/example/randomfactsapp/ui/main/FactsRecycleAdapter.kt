package com.example.randomfactsapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.randomfactsapp.R

class FactsRecycleAdapter(facts:List<String>) : RecyclerView.Adapter<FactsRecycleAdapter.FactViewHolder>() {
    private var data:List<String> = facts

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fact_item, parent, false)
        return FactViewHolder(view)
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        val fact = data[position]
        holder.setData(position.toString(),fact)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class FactViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val titleTextView: TextView = itemView.findViewById(R.id.number_title_textView)
        private val factTextView:TextView = itemView.findViewById(R.id.number_fact_textView)

        init {
            val thing = itemView.context as AppCompatActivity

        }

        fun setData(factNumber:String,randomFact:String){
            titleTextView.text = itemView.context.getString(R.string.title_string,factNumber)
            factTextView.text = randomFact
        }

    }
}