package com.example.foodcourt.homeFragment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodcourt.R
import com.example.foodcourt.model.Stores

class StoresAdapter(
    private var context: Context, private var array: ArrayList<Stores>,
) : androidx.recyclerview.widget.ListAdapter<Stores,StoresAdapter.ViewHolder>(MyDiffUtil()) {

    var myContext:Context
    init {
        myContext=context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //    val context:FragmentA
        context=parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.store_item, parent, false)
        return ViewHolder(view)
    }


//    override fun getItemCount(): Int = products.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStore:Stores = getItem(position)
      Glide.with(context).load(currentStore.storeLogo).into(holder.StoreImage)
       holder.storeName.text = currentStore.storeName
       holder.storeDescription.text = currentStore.storeDescription




    }

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val storeName = itemView.findViewById<TextView>(R.id.StoreName)
        val storeDescription = itemView.findViewById<TextView>(R.id.StoreDescription)
        val StoreImage=itemView.findViewById<ImageView>(R.id.storeImage)



    }

}

class MyDiffUtil : DiffUtil.ItemCallback<Stores>() {
    override fun areItemsTheSame(oldItem: Stores, newItem: Stores): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Stores, newItem: Stores): Boolean {
        return oldItem == newItem
    }

}