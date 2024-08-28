package com.example.tecktailor.android.landingScreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tecktailor.domain.model.OrderItem
import com.example.tecktailor.android.databinding.ItemOrderItemBinding

class OrderItemAdapter(
    private var orderItems: List<OrderItem>,
    private val onItemCheckedChange: (OrderItem, Boolean) -> Unit
) : RecyclerView.Adapter<OrderItemAdapter.OrderItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder {
        val binding = ItemOrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) {
        holder.bind(orderItems[position])
    }

    override fun getItemCount(): Int = orderItems.size

    fun submitList(newOrderItems: List<OrderItem>) {
        orderItems = newOrderItems
        notifyDataSetChanged()
    }

    inner class OrderItemViewHolder(
        private val binding: ItemOrderItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(orderItem: OrderItem) {
            binding.orderItem = orderItem

            // Update the checkbox state
            binding.completedCheckBox.isChecked = orderItem.isCompleted
            binding.completedCheckBox.setOnCheckedChangeListener { _, isChecked ->
                onItemCheckedChange(orderItem, isChecked)
            }

            // Bind other views
            binding.executePendingBindings()
        }
    }
}
