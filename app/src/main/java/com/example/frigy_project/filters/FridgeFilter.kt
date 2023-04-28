package com.example.frigy_project.filters


import android.widget.Filter
import com.example.frigy_project.adapters.FridgeAdapter
import com.example.frigy_project.models.Product
import java.util.Locale


class FridgeFilter(private val list: List<Product>, private val adapter: FridgeAdapter) : Filter() {
    private var filteredList: List<Product>? = null

    override fun performFiltering(constraint: CharSequence?): FilterResults {

        filteredList = if (constraint.isNullOrEmpty()) {
            list
            }
            else {
            list.filter { foodModel ->
                foodModel.name.toLowerCase(Locale.ROOT).contains(constraint.toString().lowercase(Locale.ROOT).trim())
                }
            }

        val results = FilterResults()
        results.values = filteredList
        return results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        if (results?.values == null) {
            adapter.submitList(adapter.originalList)
        } else {
            filteredList = results.values as List<Product>
            adapter.submitList(filteredList)
        }
    }
}
