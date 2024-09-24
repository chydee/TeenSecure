package com.j0t1m4.teensecure.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.j0t1m4.teensecure.databinding.ItemMatchingPairBinding

class MatchingAdapter(private val pairs: List<Pair<String, String>>) : RecyclerView.Adapter<MatchingAdapter.MatchingPairViewHolder>() {

    private val userMatches: MutableMap<String, String> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchingPairViewHolder {
        val binding = ItemMatchingPairBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchingPairViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchingPairViewHolder, position: Int) {
        holder.bind(pairs[position])
    }

    override fun getItemCount(): Int = pairs.size

    // Function to retrieve user-selected matches
    fun getUserMatches(): Map<String, String> = userMatches

    inner class MatchingPairViewHolder(private val binding: ItemMatchingPairBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pair: Pair<String, String>) {
            binding.termTextView.text = pair.first

            // Populate the dropdown (Spinner) with the possible answers (right-side values)
            val adapter = ArrayAdapter(
                binding.root.context,
                android.R.layout.simple_spinner_item,
                pairs.map { it.second }
            )
            binding.matchDropdown.adapter = adapter

            // Set up the listener for the dropdown (Spinner)
            binding.matchDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    // Store the user's selection in the userMatches map
                    userMatches[pair.first] = pairs[position].second
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Handle the case where no selection is made, if necessary
                }
            }
        }
    }

}
