package com.example.frigy_project.filters

import android.widget.Filter
import com.example.frigy_project.adapters.FoodAdapter
import com.example.frigy_project.models.FoodModel
import java.util.Locale


class FridgeFilter(private val list: List<FoodModel>, private val adapter: FoodAdapter) : Filter() {
    private var filteredList: List<FoodModel> = list

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        val query = constraint.toString().toLowerCase(Locale.ROOT).trim()

        filteredList = if (query.isEmpty()) {
            list
        } else {
            list.filter { myModel ->
                myModel.name.toLowerCase(Locale.ROOT).contains(query)
            }
        }

        val results = FilterResults()
        results.values = filteredList
        return results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        filteredList = results?.values as List<FoodModel>
        adapter.submitList(filteredList)
    }
}
