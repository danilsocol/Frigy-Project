package com.example.frigy_project


import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.frigy_project.databinding.FragmentFridgeBinding
import com.example.frigy_project.models.FoodModel


class FridgeFragment : Fragment() {

    private lateinit var binding: FragmentFridgeBinding
    private val foodAdapter = FoodAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        binding = FragmentFridgeBinding.inflate(layoutInflater)

        init()
        return inflater.inflate(R.layout.fragment_fridge, container, false)
    }


    private fun init() {
        val list = listOf<FoodModel>(FoodModel(1,"Молоко",0,false,1.0,0.0))
        foodAdapter.submitList(list)

        binding.apply {
            rcViewFridge.layoutManager = GridLayoutManager(context, 2)
            rcViewFridge.adapter = foodAdapter
        }
    }

   /* override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.search_menu, menu)

        val search = menu.findItem(R.id.search)
        val searchView = search.actionView as SearchView
        searchView.queryHint = "Поиск"

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                foodAdapter.getFilter().filter(newText)
                return true
            }
        }
        )

}*/
    override fun onDestroyView() {
        super.onDestroyView() //todo удаление
/*        binding = null*/
    }
}