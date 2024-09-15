package app.fatal.assignment_1_booking.model

import java.util.Date

data class Deal (
    val id: Int,
    val dealName: String,
    val dealType: Enum<DealType>,
    val dealDate: Date,
    val payment: Float,
)