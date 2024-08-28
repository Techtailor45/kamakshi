package com.example.tecktailor.domain.model

// Data class for Order
data class Order(
    val orderId: String,                 // Unique identifier for the order
    val title: String,                   // Title of the order (e.g., "Wedding Suit Order")
    val details: String,                 // Detailed description of the order
    val createdAt: String,               // Date when the order was created
    val customerName: String,            // Name of the customer
    val customerNumber: String,          // Contact number of the customer
    val customerImg: String?,            // URL or path to the customer's image (if available)
    val customerAddress: String,         // Address of the customer
    val deliveryDate: String,            // Expected delivery date for the order
    val totalPrice: Double,              // Total price of the order
    val status: Int,             // Current status of the order (e.g., Pending, In Progress)
    val paymentStatus: Int,    // Payment status (e.g., Paid, Unpaid)
    val specialInstructions: String?,    // Special instructions or notes from the customer
    val items: List<OrderItem>  ,         // List of items included in the order
    val isUrgent: Boolean                 // Flag to indicate if the order is urgent
)

// Data class for OrderItem
data class OrderItem(
    val itemId: String,                // Unique identifier for the item
    val name: String,                  // Name of the item (e.g., "Jacket", "Pants")
    val garmentType: String,           // Type of garment (e.g., suit, dress, shirt)
    val measurements: Measurements,    // Measurements specific to this item
    val fabricType: String,            // Type of fabric chosen for the garment
    val quantity: Int,                 // Quantity of this item in the order
    val pricePerItem: Double,          // Price per item
    val notes: String? ,                // Any specific notes related to the item
    val isCompleted: Boolean = false           //Is Item made or not
)

// Additional class to hold measurements for tailoring
data class Measurements(
    val chest: Double,                 // Chest measurement in inches or centimeters
    val waist: Double,                 // Waist measurement
    val hips: Double,                  // Hips measurement
    val inseam: Double,                // Inseam measurement for pants
    val sleeveLength: Double,          // Sleeve length for shirts or jackets
    val shoulderWidth: Double          // Shoulder width
)


