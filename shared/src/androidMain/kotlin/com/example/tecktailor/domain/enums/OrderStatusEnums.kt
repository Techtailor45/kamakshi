package com.example.tecktailor.domain.enums

// Enum to represent order status
enum class OrderStatus(val value: Int) {
    PENDING(0),       // Order is pending and not started yet
    IN_PROGRESS(1),   // Order is currently being worked on
    COMPLETED(2),     // Order is completed and ready for pickup/delivery
    CANCELED(3);      // Order was canceled

    companion object {
        fun fromInt(value: Int): OrderStatus {
            return values().firstOrNull { it.value == value } ?: PENDING
        }
    }
}

// Enum to represent payment status
enum class PaymentStatus(val value: Int) {
    PAID(0),          // Payment is complete
    UNPAID(1),        // Payment is pending
    PARTIALLY_PAID(2); // Partial payment has been made

    companion object {
        fun fromInt(value: Int): PaymentStatus {
            return values().firstOrNull { it.value == value } ?: UNPAID
        }
    }
}