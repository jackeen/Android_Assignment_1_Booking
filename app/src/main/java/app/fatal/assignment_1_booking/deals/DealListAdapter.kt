package app.fatal.assignment_1_booking.deals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.model.Deal
import app.fatal.assignment_1_booking.model.DealType
import java.text.SimpleDateFormat

class DealListAdapter(
    private val data: List<Deal>,
    private val listener: IDealItemListener
) : RecyclerView.Adapter<DealListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.deal_list_item, parent, false)
        return DealListHolder(view)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: DealListHolder, position: Int) {
        val itemData = data.get(position)
        var icon = R.drawable.baseline_restaurant_24
        if (itemData.dealType == DealType.PLACE) {
            icon = R.drawable.baseline_attractions_24
        } else if (itemData.dealType == DealType.STAY) {
            icon = R.drawable.baseline_hotel_24
        }

        val dateFormat = SimpleDateFormat("dd MMM yyyy")

        holder.iconView.setImageResource(icon)
        holder.nameView.text = itemData.dealName
        holder.dateView.text = dateFormat.format(itemData.dealDate)
        holder.priceView.text = itemData.payment.toString()

        holder.view.setOnClickListener(View.OnClickListener {
            listener.onItemClick(position, itemData)
        })
    }
}