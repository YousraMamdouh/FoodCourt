package com.example.foodcourt.homeFragment.view

import StoresClient
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcourt.R
import com.example.foodcourt.homeFragment.viewModel.HomeFragmentViewModel
import com.example.foodcourt.homeFragment.viewModel.HomeFragmentViewModelFactory
import com.example.foodcourt.model.Repository
import com.example.foodcourt.model.Store
import java.util.*
import kotlin.collections.ArrayList

class HomeFragmentView : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var factory: HomeFragmentViewModelFactory
    lateinit var viewModel: HomeFragmentViewModel
    lateinit var adapter: StoresAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var searchView: SearchView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        factory= HomeFragmentViewModelFactory(
            Repository.getInstance(
                StoresClient.getInstance()

            ))
        viewModel= ViewModelProvider(this,factory).get(HomeFragmentViewModel::class.java)

        setUpRecyclerView()

        viewModel.products.observe(this){products->
            if(products!=null){
                adapter.submitList(products)
            }

        }
        setSearchViewLogic()
    }
  fun setSearchViewLogic()
  {
      searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
          override fun onQueryTextSubmit(p0: String?): Boolean {
            return false
          }

          override fun onQueryTextChange(p0: String?): Boolean {
              p0?.let { filterList(it) }
              return true
          }

      })
  }

    private fun filterList(query:String) {
        if (query != null) {
            var filteredList = ArrayList<Store>()
            viewModel.products.observe(viewLifecycleOwner) { stores ->


                for (store in stores) {
                  if(store.storeName.lowercase(Locale.ROOT).contains(query))
                  {
                      filteredList.add(store)
                  }
                }
                if(!filteredList.isEmpty())
                {
                    viewModel.products.observe(this){products->
                            adapter.submitList(filteredList)


                    }
                }
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_view, container, false)
    }

    private fun setUpRecyclerView() {
        layoutManager=LinearLayoutManager(activity)
        layoutManager.orientation=RecyclerView.VERTICAL
        adapter= activity?.let { StoresAdapter(it,ArrayList()) }!!
        recyclerView.adapter=adapter
        recyclerView.layoutManager=layoutManager
    }
}