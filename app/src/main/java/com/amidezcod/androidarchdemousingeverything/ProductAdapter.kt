package com.amidezcod.androidarchdemousingeverything

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProductAdapter : BaseQueuedAdapter<Product, ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.recylerview_item,
                        parent,
                        false))
    }

    override fun getItemCount(): Int = super.mDataset.size


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(mDataset[position])
    }

    fun addProducts(it: List<Product>) {
        update(it)
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.findViewById<TextView>(R.id.text_view).text = product.title
        }
    }

}