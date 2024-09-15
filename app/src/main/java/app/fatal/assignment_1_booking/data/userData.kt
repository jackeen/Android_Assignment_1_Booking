package app.fatal.assignment_1_booking.data

import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.model.Role
import app.fatal.assignment_1_booking.model.User

// Create user instances with different roles
val users = listOf(
    User(
        userName = "customer",
        password = "password",
        firstName = "John",
        lastName = "Doe",
        phone = "123-456-7890",
        email = "john.doe@example.com",
        role = Role.CUSTOMER,
        avatar = R.drawable.customer,
    ),
    User(
        userName = "supplier",
        password = "password",
        firstName = "Jane",
        lastName = "Smith",
        phone = "987-654-3210",
        email = "jane.smith@example.com",
        role = Role.SUPPLIER,
        avatar = R.drawable.supplier,
    ),
    User(
        userName = "manager",
        password = "password",
        firstName = "Admin",
        lastName = "Manager",
        phone = "555-555-5555",
        email = "admin.user@example.com",
        role = Role.ADMIN,
        avatar = R.drawable.manager
    )
)
