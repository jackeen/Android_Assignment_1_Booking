package app.fatal.assignment_1_booking.model

data class User (
    val userName: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val role: Enum<Role>,
    val avatar: Int
)