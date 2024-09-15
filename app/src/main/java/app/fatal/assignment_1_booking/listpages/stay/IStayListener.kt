package app.fatal.assignment_1_booking.listpages.stay

import app.fatal.assignment_1_booking.model.Stay

interface IStayListener {
    fun onItemClick(position: Int, item: Stay)
}