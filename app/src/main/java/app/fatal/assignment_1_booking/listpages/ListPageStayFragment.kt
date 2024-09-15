package app.fatal.assignment_1_booking.listpages

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.StayDetailActivity
import app.fatal.assignment_1_booking.data.stays
import app.fatal.assignment_1_booking.listpages.stay.IStayListener
import app.fatal.assignment_1_booking.listpages.stay.StayAdapter
import app.fatal.assignment_1_booking.model.Country
import app.fatal.assignment_1_booking.model.Stay
import java.util.Calendar

class ListPageStayFragment(private val country: Country) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_stay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDateStart = view.findViewById<Button>(R.id.list_stay_start_date_btn)
        btnDateStart.setOnClickListener(View.OnClickListener {
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

        val btnDateEnd = view.findViewById<Button>(R.id.list_stay_end_date_btn)
        btnDateEnd.setOnClickListener(View.OnClickListener {
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

        val data = stays.filter { it.country == country }

        val rvStay = view.findViewById<RecyclerView>(R.id.list_stay_rv)
        var adapter = StayAdapter(data, object: IStayListener {
            override fun onItemClick(position: Int, item: Stay) {
                val intent = Intent(view.context, StayDetailActivity::class.java)
                intent.putExtra("title", item.name)
                startActivity(intent)
            }
        })
        rvStay.adapter = adapter
        rvStay.layoutManager = LinearLayoutManager(view.context)


    }
}