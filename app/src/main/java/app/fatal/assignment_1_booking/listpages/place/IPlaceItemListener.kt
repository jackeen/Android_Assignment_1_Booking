package app.fatal.assignment_1_booking.listpages.place

import app.fatal.assignment_1_booking.model.Destination

// for destination item of list click event
interface IPlaceItemListener {
    fun onItemClick(position: Int, item: Destination)
}