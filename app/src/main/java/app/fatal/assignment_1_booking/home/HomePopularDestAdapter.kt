package app.fatal.assignment_1_booking.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import app.fatal.assignment_1_booking.R
import app.fatal.assignment_1_booking.listpages.place.IPlaceItemListener
import app.fatal.assignment_1_booking.model.Destination

class HomePopularDestAdapter(
    private var data: List<Destination>,
    private var clickListener: IPlaceItemListener
) : Adapter<HomePopularDestHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePopularDestHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_popular_dest_item, parent, false)
        return HomePopularDestHolder(view)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: HomePopularDestHolder, position: Int) {
        holder.titleView.text = data[position].name
        holder.imageView.setImageResource(data[position].imageSrc)
        holder.view.setOnClickListener(View.OnClickListener {
            clickListener.onItemClick(position, data[position])
        })
    }

    fun UpdateDataset(newData: List<Destination>) {
        data = newData
        notifyDataSetChanged()
    }
}