package app.fatal.assignment_1_booking.model

data class Restaurant (
    val name: String,
    val location: String,
    val country: Country,
    val description: String,
    val price: Float,
    val discount: Int,
    val rating: Float,
    var spaces: Int,
    var imageSrc: Int,
    var weekDays: Array<String>,
)