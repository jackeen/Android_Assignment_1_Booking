package app.fatal.assignment_1_booking.listpages.restaurant

import app.fatal.assignment_1_booking.model.Restaurant

interface IRestaurantListener {
    fun onItemClick(position: Int, item: Restaurant)
}