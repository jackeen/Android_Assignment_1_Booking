package app.fatal.assignment_1_booking.data

import app.fatal.assignment_1_booking.model.Deal
import app.fatal.assignment_1_booking.model.DealType
import java.util.Date

val deals = listOf(
    Deal(
        id = 1,
        dealName = "Queenstown - Southern Lakes - Fiordland",
        dealType = DealType.PLACE,
        dealDate = Date(),
        payment = 180.0f
    ),
    Deal(
        id = 2,
        dealName = "Orphans Kitchen",
        dealType = DealType.RESTAURANT,
        dealDate = Date(),
        payment = 60.0f
    ),
    Deal(
        id = 3,
        dealName = "The Star Grand Sydney",
        dealType = DealType.STAY,
        dealDate = Date(),
        payment = 320.0f
    )
)