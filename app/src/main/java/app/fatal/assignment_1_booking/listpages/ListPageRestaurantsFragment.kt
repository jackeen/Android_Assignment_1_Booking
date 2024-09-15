package app.fatal.assignment_1_booking.listpages

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.RestaurantDetailActivity
import app.fatal.assignment_1_booking.data.restaurants
import app.fatal.assignment_1_booking.listpages.restaurant.IRestaurantListener
import app.fatal.assignment_1_booking.listpages.restaurant.RestaurantAdapter
import app.fatal.assignment_1_booking.model.Country
import app.fatal.assignment_1_booking.model.Restaurant
import java.time.Month
import java.time.MonthDay
import java.time.Year
import java.util.Calendar

class ListPageRestaurantsFragment(private val country: Country) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // date picker
        val btnDate = view.findViewById<Button>(R.id.list_restaurant_date_btn)
        btnDate.setOnClickListener(View.OnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val dateDialog = DatePickerDialog(
                view.context,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Format the selected date and display it
                    //val selectedDate = Calendar.getInstance()
                    //selectedDate.set(selectedYear, selectedMonth, selectedDay)
                    //val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    //val formattedDate = dateFormat.format(selectedDate.time)
                    //dateDisplay.text = "Selected Date: $formattedDate"
                },
                year,
                month,
                day
            )
            dateDialog.show()
        })

        // time picker
        val btnTime = view.findViewById<Button>(R.id.list_restaurant_time_btn)
        btnTime.setOnClickListener(View.OnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Create and show the TimePickerDialog
            val timePickerDialog = TimePickerDialog(
                view.context,
                { _, selectedHour, selectedMinute ->

                },
                hour,
                minute,
                true
            )
            timePickerDialog.show()
        })

        // list of restaurant
        val data = restaurants.filter { it.country == country }
        if (data.count() == 0) {
            view.findViewById<TextView>(R.id.list_restaurant_no_data).visibility = View.VISIBLE
        } else {
            val rvRestaurant = view.findViewById<RecyclerView>(R.id.list_restaurant_rv)
            val adapter = RestaurantAdapter(data, object: IRestaurantListener {
                override fun onItemClick(position: Int, item: Restaurant) {
                    val intent = Intent(view.context, RestaurantDetailActivity::class.java)
                    intent.putExtra("title", item.name)
                    startActivity(intent)
                }
            })
            rvRestaurant.adapter = adapter
            rvRestaurant.layoutManager = LinearLayoutManager(view.context)
        }
    }

}