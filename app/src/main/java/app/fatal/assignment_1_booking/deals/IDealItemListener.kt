package app.fatal.assignment_1_booking.deals

import app.fatal.assignment_1_booking.model.Deal

interface IDealItemListener {
    fun onItemClick(position: Int, item: Deal)
}