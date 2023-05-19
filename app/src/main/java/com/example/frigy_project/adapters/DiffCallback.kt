package com.example.frigy_project.adapters

import androidx.recyclerview.widget.DiffUtil

class DiffCallback<T : Any>: DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return newItem == oldItem
    }
}