package com.example.tecktailor.android.landingScreen.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecktailor.android.common.base.BaseFragment
import com.example.tecktailor.android.databinding.FragmentOrderItemBinding
import com.example.tecktailor.android.landingScreen.adapters.OrderItemAdapter
import com.example.tecktailor.domain.model.Measurements
import com.example.tecktailor.domain.model.OrderItem

class OrderItemFragment : BaseFragment<FragmentOrderItemBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOrderItemBinding {
        TODO("Not yet implemented")
    }

    override fun fetchData() {
        TODO("Not yet implemented")
    }

    override fun setUpViews() {
        binding?.apply {
            val orderItems = listOf(
                OrderItem("1", "Jacket", "Suit", Measurements(40.0, 32.0, 38.0, 30.0, 24.0, 18.0), "Wool", 1, 100.0, "No notes",false),
                OrderItem("2", "Pants", "Suit", Measurements(40.0, 32.0, 38.0, 30.0, 24.0, 18.0), "Cotton", 2, 50.0, "No notes",false)
            )
            val adapter = OrderItemAdapter(orderItems) { orderItem, isChecked ->
                // Handle the checkbox state change here
                // Update your data source if needed
                //todo handle completing the item
            }

            rvOrderItems.layoutManager = LinearLayoutManager(requireContext())
            rvOrderItems.adapter =  adapter
        }
    }

    override fun setUpListeners() {
        TODO("Not yet implemented")
    }
}