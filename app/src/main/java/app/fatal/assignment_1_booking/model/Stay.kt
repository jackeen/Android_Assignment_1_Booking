package app.fatal.assignment_1_booking.model

import java.sql.Time

data class Stay (
    val name: String,
    val location: String,
    val country: Country,
    val description: String,
    val price: Float,
    val rating: Float,
    val capacity: Int,
    val roomTypeName: String,
    val bedTypeName: String,
    val checkInTime: Time,
    val checkOutTime: Time,
    val phone: String,
    val hasNotification: Boolean,
    val hasTV: Boolean,
    val hasWIFI: Boolean,
    val imageSrc: Int,
)