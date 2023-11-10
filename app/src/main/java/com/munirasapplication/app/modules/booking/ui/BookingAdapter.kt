package com.munirasapplication.app.modules.booking.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.munirasapplication.app.R
import com.munirasapplication.app.databinding.RowBookingBinding
import com.munirasapplication.app.modules.booking.`data`.model.BookingRowModel
import kotlin.Int
import kotlin.collections.List

class BookingAdapter(
  var list: List<BookingRowModel>
) : RecyclerView.Adapter<BookingAdapter.RowBookingVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowBookingVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_booking,parent,false)
    return RowBookingVH(view)
  }

  override fun onBindViewHolder(holder: RowBookingVH, position: Int) {
    val bookingRowModel = BookingRowModel()
    // TODO uncomment following line after integration with data source
    // val bookingRowModel = list[position]
    holder.binding.bookingRowModel = bookingRowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<BookingRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: BookingRowModel
    ) {
    }
  }

  inner class RowBookingVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowBookingBinding = RowBookingBinding.bind(itemView)
  }
}
