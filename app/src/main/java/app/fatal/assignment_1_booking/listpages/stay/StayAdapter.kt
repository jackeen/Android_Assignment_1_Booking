package app.fatal.assignment_1_booking.listpages.stay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.model.Stay

class StayAdapter(
    private val data: List<Stay>,
    private val listener: IStayListener
    ) : RecyclerView.Adapter<StayAdapter.StayHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StayHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_page_recycler_item_stay, parent, false)
        return StayHolder(view)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: StayHolder, position: Int) {
        val d = data.get(position)
        holder.imageView.setImageResource(d.imageSrc)
        holder.titleView.text = d.name
        holder.ratingView.rating = d.rating
        holder.priceView.text = "$${d.price}"
        holder.roomView.text = d.roomTypeName
        holder.bedView.text = d.bedTypeName

        holder.view.setOnClickListener(View.OnClickListener {
            listener.onItemClick(position, d)
        })
    }

    inner class StayHolder(item: View) : RecyclerView.ViewHolder(item) {
        val view = item
        val imageView = view.findViewById<ImageView>(R.id.list_stay_item_image)
        val titleView = view.findViewById<TextView>(R.id.list_stay_item_title)
        val ratingView = view.findViewById<RatingBar>(R.id.list_stay_item_rating)
        val roomView = view.findViewById<TextView>(R.id.list_stay_item_room_type_name)
        val bedView = view.findViewById<TextView>(R.id.list_stay_item_bed_type_name)
        val priceView = view.findViewById<TextView>(R.id.list_stay_item_price)
    }
}