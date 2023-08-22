package com.example.foodcourt.homeFragment.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodcourt.R
import com.example.foodcourt.model.Store

class StoresAdapter(
    private var context: Context, private var array: ArrayList<Store>,
) : androidx.recyclerview.widget.ListAdapter<Store,StoresAdapter.ViewHolder>(MyDiffUtil()) {

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
        val currentStore:Store = getItem(position)
      Glide.with(context).load(currentStore.StoreLogo).placeholder(R.drawable.placeholder_image).into(holder.StoreImage)

       holder.storeName.text = currentStore.StoreName
       holder.storeDescription.text = currentStore.StoreDescription




    }

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val storeName = itemView.findViewById<TextView>(R.id.StoreName)
        val storeDescription = itemView.findViewById<TextView>(R.id.StoreDescription)
        val StoreImage=itemView.findViewById<ImageView>(R.id.storeImage)



    }

}

class MyDiffUtil : DiffUtil.ItemCallback<Store>() {
    override fun areItemsTheSame(oldItem: Store, newItem: Store): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Store, newItem: Store): Boolean {
        return oldItem == newItem
    }

}