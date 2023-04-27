package com.example.frigy_project.filters


import android.util.Log
import android.widget.Filter
import com.example.frigy_project.adapters.FoodAdapter
import com.example.frigy_project.models.FoodModel
import java.util.Locale


class FridgeFilter(private val list: List<FoodModel>, private val adapter: FoodAdapter) : Filter() {
    private var filteredList: List<FoodModel>? = null

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        val query = constraint.toString().toLowerCase(Locale.ROOT).trim()

        filteredList = if (query.isEmpty()) {
            list
            }
            else {
            list.filter { myModel ->
                myModel.name.toLowerCase(Locale.ROOT).contains(query)
                }
            }

        val results = FilterResults()
        if(filteredList!!.isEmpty())
            results.values = null
        else
            results.values = filteredList
        return results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        if (results?.values == null) {
            adapter.submitList(adapter.originalList)
        } else {
            filteredList = results.values as List<FoodModel>
            adapter.submitList(filteredList)
        }
    }
}
