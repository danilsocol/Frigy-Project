package com.example.frigy_project.presentation.filters

import android.widget.Filter
import com.example.frigy_project.presentation.adapters.BaseAdapter
import com.example.frigy_project.presentation.dtos.IFilterable
import java.util.Locale

class TitleFilter<T>(private val list: List<T>, private val adapter: BaseAdapter<T>) : Filter()
        where T : IFilterable
{

    private var filteredList: List<T>? = null

    override fun performFiltering(constraint: CharSequence?): FilterResults {

        filteredList = if (constraint.isNullOrEmpty()) {
            list
        }
        else {
            list.filter { foodModel ->
                foodModel.name.lowercase(Locale.ROOT)
                    .contains(constraint.toString().lowercase(Locale.ROOT).trim())
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
            filteredList = results.values as List<T>
            adapter.submitList(filteredList)
        }
    }
}