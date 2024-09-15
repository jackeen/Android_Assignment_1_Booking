package app.fatal.assignment_1_booking.model

enum class DealType(val code: String, val value: String) {
    PLACE("PLACE", "Place"),
    RESTAURANT("RESTAURANT", "Restaurant"),
    STAY("STAY", "Stay")
}