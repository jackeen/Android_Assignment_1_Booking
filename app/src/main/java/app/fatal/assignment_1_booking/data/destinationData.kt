import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.model.Country
import app.fatal.assignment_1_booking.model.Destination


val destinations = listOf(
    Destination(
        name = "Dunedin - Coastal Otago - Oamaru",
        location = "New Zealand",
        country = Country.NZ,
        description = "Explore the historic city of Dunedin, the coastal beauty of Otago, and the charming town of Oamaru. Known for its Victorian and Edwardian architecture.",
        price = 120.0f,
        discount = 15,
        rating = 4.5f,
        spaces = 10,
        bestMonth = "December",
        imageSrc = R.drawable.home_nz_desdunedin
    ),
    Destination(
        name = "Gisborne - East Cape to Mahia",
        location = "New Zealand",
        country = Country.NZ,
        description = "Discover the East Cape and Mahia Peninsula with stunning beaches, unique Maori culture, and beautiful landscapes.",
        price = 100.0f,
        discount = 10,
        rating = 4.3f,
        spaces = 8,
        bestMonth = "January",
        imageSrc = R.drawable.home_nz_desgisborne_eastcape
    ),
    Destination(
        name = "Northland - Bay of Islands",
        location = "New Zealand",
        country = Country.NZ,
        description = "Enjoy the Bay of Islands with its pristine waters, rich history, and vibrant marine life. A perfect spot for sailing and fishing.",
        price = 140.0f,
        discount = 20,
        rating = 4.7f,
        spaces = 12,
        bestMonth = "February",
        imageSrc = R.drawable.home_nz_desnorthland_bay_of_islands
    ),
    Destination(
        name = "Queenstown - Southern Lakes - Fiordland",
        location = "New Zealand",
        country = Country.NZ,
        description = "Queenstown is known for its adventure sports, breathtaking Southern Lakes, and Fiordland's magnificent fjords. A must-visit for thrill-seekers and nature lovers.",
        price = 180.0f,
        discount = 25,
        rating = 4.8f,
        spaces = 15,
        bestMonth = "November",
        imageSrc = R.drawable.home_nz_desqueenstown
    ),
    Destination(
        name = "Rotorua - Taupo - Waitomo",
        location = "New Zealand",
        country = Country.NZ,
        description = "Explore Rotorua's geothermal wonders, Taupo's stunning lake, and Waitomo's famous glowworm caves. A diverse region offering both relaxation and adventure.",
        price = 130.0f,
        discount = 18,
        rating = 4.6f,
        spaces = 20,
        bestMonth = "March",
        imageSrc = R.drawable.home_nz_desrotorua_taupo
    ),
    Destination(
        name = "Taranaki - New Plymouth",
        location = "New Zealand",
        country = Country.NZ,
        description = "Experience Taranaki's volcanic landscape, lush gardens, and the vibrant city of New Plymouth. Ideal for outdoor enthusiasts and cultural explorers.",
        price = 110.0f,
        discount = 12,
        rating = 4.4f,
        spaces = 9,
        bestMonth = "April",
        imageSrc = R.drawable.home_nz_destaranaki_new_plymouth
    ),
    Destination(
        name = "BOP - Tauranga - Maunganui - Whakatane",
        location = "New Zealand",
        country = Country.NZ,
        description = "Enjoy the Bay of Plenty with Tauranga's lively waterfront, Maunganui's stunning beach, and Whakatane's cultural experiences. A region rich in natural beauty and activities.",
        price = 125.0f,
        discount = 14,
        rating = 4.5f,
        spaces = 11,
        bestMonth = "October",
        imageSrc = R.drawable.home_nz_desrotorua_taupo // Assuming duplicate image for illustration
    ),
    Destination(
        name = "Gold Coast",
        location = "Australia",
        country = Country.AU,
        description = "Experience the vibrant Gold Coast with its beautiful beaches, exciting theme parks, and lively nightlife. A perfect destination for both relaxation and adventure.",
        price = 150.0f,
        discount = 20,
        rating = 4.7f,
        spaces = 18,
        bestMonth = "December",
        imageSrc = R.drawable.home_au_dest_gold_coast
    ),
    Destination(
        name = "Cairns - Port Douglas",
        location = "Australia",
        country = Country.AU,
        description = "Discover the tropical paradise of Cairns and Port Douglas. Enjoy the Great Barrier Reef, lush rainforests, and luxurious resorts.",
        price = 170.0f,
        discount = 15,
        rating = 4.6f,
        spaces = 14,
        bestMonth = "July",
        imageSrc = R.drawable.home_au_dest_cairns_port_douglas
    ),
    Destination(
        name = "Yasawa Islands",
        country = Country.FJ,
        location = "Yasawa Islands, Fiji",
        description = "A stunning island chain known for its white sandy beaches and crystal-clear lagoons. Ideal for beach lovers, snorkelers, and those seeking tranquility.",
        price = 1500.0f,
        discount = 10,
        rating = 4.8f,
        spaces = 5,
        bestMonth = "July",
        imageSrc = R.drawable.yasawa_islands  // Replace with an actual image resource ID
    )
)
