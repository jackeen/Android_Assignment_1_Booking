package app.fatal.assignment_1_booking.data

import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.model.Country
import app.fatal.assignment_1_booking.model.Restaurant


val restaurants = listOf(
    Restaurant(
        name = "The Grove",
        country = Country.NZ,
        location = "Auckland",
        description = "Fine dining experience with a focus on modern New Zealand cuisine.",
        price = 150.0f,
        discount = 10,
        rating = 4.9f,
        spaces = 5,
        imageSrc = R.drawable.list_nz_restaurant_1,
        weekDays = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    ),
    Restaurant(
        name = "Fleur's Place",
        location = "Moeraki, Otago",
        country = Country.NZ,
        description = "Seafood restaurant right by the water offering fresh local catch.",
        price = 90.0f,
        discount = 5,
        rating = 4.8f,
        spaces = 8,
        imageSrc = R.drawable.list_nz_restaurant_2,
        weekDays = arrayOf("Thursday", "Friday", "Saturday", "Sunday")
    ),
    Restaurant(
        name = "Orphans Kitchen",
        location = "Ponsonby, Auckland",
        country = Country.NZ,
        description = "A local favorite with innovative takes on New Zealand ingredients.",
        price = 60.0f,
        discount = 0,
        rating = 4.7f,
        spaces = 10,
        imageSrc = R.drawable.list_nz_restaurant_3,
        weekDays = arrayOf("Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    ),
    Restaurant(
        name = "Riverstone Kitchen",
        location = "Oamaru, Otago",
        country = Country.NZ,
        description = "Award-winning restaurant with a focus on fresh, seasonal produce.",
        price = 120.0f,
        discount = 15,
        rating = 4.8f,
        spaces = 7,
        imageSrc = R.drawable.list_nz_restaurant_4,
        weekDays = arrayOf("Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    ),
    Restaurant(
        name = "Huka Lodge",
        location = "Taupo, Waikato",
        country = Country.NZ,
        description = "Luxury riverside dining with a strong focus on fine New Zealand wines.",
        price = 300.0f,
        discount = 20,
        rating = 5.0f,
        spaces = 4,
        imageSrc = R.drawable.list_nz_restaurant_5,
        weekDays = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    )
)
