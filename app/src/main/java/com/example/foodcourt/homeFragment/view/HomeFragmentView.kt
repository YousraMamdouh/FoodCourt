package com.example.foodcourt.homeFragment.view

import StoresClient
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcourt.R
import com.example.foodcourt.homeFragment.viewModel.HomeFragmentViewModel
import com.example.foodcourt.homeFragment.viewModel.HomeFragmentViewModelFactory
import com.example.foodcourt.model.Repository

class HomeFragmentView : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var factory: HomeFragmentViewModelFactory
    lateinit var viewModel: HomeFragmentViewModel
    lateinit var adapter: StoresAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)

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