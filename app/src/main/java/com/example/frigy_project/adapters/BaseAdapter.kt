package com.example.frigy_project.adapters

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.frigy_project.models.Product

abstract class BaseAdapter<T : Any> : ListAdapter<T, RecyclerView.ViewHolder>(DiffCallback<T>()), IFilterable<T>
{
    var originalList : List<T>? = null
}