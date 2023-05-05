package com.example.frigy_project.adapters

import android.widget.Filterable
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : Any> : ListAdapter<T, RecyclerView.ViewHolder>(DiffCallback<T>()),
    Filterable
{
    var originalList : List<T>? = null
    abstract fun setData(newList: List<T>)
}