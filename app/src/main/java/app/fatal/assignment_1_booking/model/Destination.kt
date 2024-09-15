package app.fatal.assignment_1_booking.model

data class Destination (
    val name: String,
    var country: Enum<Country>,
    val location: String,
    val description: String,
    val price: Float,
    val discount: Int,
    val rating: Float,
    var spaces: Int,
    var bestMonth: String,
    var imageSrc: Int,
)