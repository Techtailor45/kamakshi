package com.example.tecktailor.android.landingScreen.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecktailor.android.common.base.BaseFragment
import com.example.tecktailor.android.databinding.FragmentMyOrdersBinding
import com.example.tecktailor.android.landingScreen.adapters.OrdersAdapter
import com.example.tecktailor.domain.enums.OrderStatus
import com.example.tecktailor.domain.enums.PaymentStatus
import com.example.tecktailor.domain.model.Measurements
import com.example.tecktailor.domain.model.Order
import com.example.tecktailor.domain.model.OrderItem

class MyOrdersFragment : BaseFragment<FragmentMyOrdersBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMyOrdersBinding {
        return FragmentMyOrdersBinding.inflate(inflater, container, false)
    }

    override fun fetchData() {
        // Fetch data if necessary
    }

    override fun setUpViews() {
        // Set up your views here
        binding?.rvOrders?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = OrdersAdapter(generateDummyOrders()) { order ->
                //todo show order items
                addFragment(OrderItemFragment(),true,"OrderItemFragment")
            }
        }
    }

    override fun setUpListeners() {
        // Set up your listeners here
    }
}

fun generateDummyOrders(): List<Order> {
    val orderItems = listOf(
        OrderItem(
            itemId = "item1",
            name = "Jacket",
            garmentType = "Outerwear",
            measurements = Measurements(
                chest = 40.0,
                waist = 32.0,
                hips = 38.0,
                inseam = 30.0,
                sleeveLength = 25.0,
                shoulderWidth = 18.0
            ),
            fabricType = "Wool",
            quantity = 1,
            pricePerItem = 150.0,
            notes = "Need custom embroidery"
        ),
        OrderItem(
            itemId = "item2",
            name = "Pants",
            garmentType = "Bottoms",
            measurements = Measurements(
                chest = 0.0, // Not applicable
                waist = 34.0,
                hips = 40.0,
                inseam = 32.0,
                sleeveLength = 0.0, // Not applicable
                shoulderWidth = 0.0 // Not applicable
            ),
            fabricType = "Cotton",
            quantity = 2,
            pricePerItem = 80.0,
            notes = "Adjust waist size"
        )
    )

    return listOf(
        Order(
            orderId = "order1",
            title = "Wedding Suit",
            details = "Tailored wedding suit for the groom.",
            createdAt = "2024-08-28",
            customerName = "John Doe",
            customerNumber = "+1234567890",
            customerImg = null,
            customerAddress = "123 Elm Street, Springfield",
            deliveryDate = "2024-09-15",
            totalPrice = 230.0,
            status = OrderStatus.PENDING.ordinal,
            paymentStatus = PaymentStatus.UNPAID.ordinal,
            specialInstructions = "Handle with care.",
            items = orderItems,
            isUrgent = true
        ),
        Order(
            orderId = "order2",
            title = "Casual Shirt",
            details = "Casual shirt for daily wear.",
            createdAt = "2024-08-15",
            customerName = "Jane Smith",
            customerNumber = "+0987654321",
            customerImg = "http://example.com/image.jpg",
            customerAddress = "456 Oak Avenue, Springfield",
            deliveryDate = "2024-09-01",
            totalPrice = 60.0,
            status = OrderStatus.COMPLETED.ordinal,
            paymentStatus = PaymentStatus.PAID.ordinal,
            specialInstructions = null,
            items = listOf(
                OrderItem(
                    itemId = "item3",
                    name = "Shirt",
                    garmentType = "Topwear",
                    measurements = Measurements(
                        chest = 42.0,
                        waist = 34.0,
                        hips = 0.0, // Not applicable
                        inseam = 0.0, // Not applicable
                        sleeveLength = 25.0,
                        shoulderWidth = 19.0
                    ),
                    fabricType = "Linen",
                    quantity = 1,
                    pricePerItem = 60.0,
                    notes = "No special instructions"
                )
            ),
            isUrgent = false
        )
    )
}
