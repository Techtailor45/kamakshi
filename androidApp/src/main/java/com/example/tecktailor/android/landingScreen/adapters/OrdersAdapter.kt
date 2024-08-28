package com.example.tecktailor.android.landingScreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecktailor.android.databinding.ItemOrderBinding
import com.example.tecktailor.domain.model.Order
import com.example.tecktailor.utils.interfaces.IViewClicked

class OrdersAdapter(
    private val orders: List<Order>,
    val onOrderClicked: (Order) -> Unit
) :
    RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    // ViewHolder class for RecyclerView items using DataBinding
    inner class OrderViewHolder(private val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            binding.order = order   // Bind the order to the layout
            binding.onClick = object : IViewClicked {
                override fun onClick() {
                    onOrderClicked.invoke(order)

                }

            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        // Inflate the layout using DataBinding
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemOrderBinding.inflate(layoutInflater, parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orders[position])  // Bind the data to the ViewHolder
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}