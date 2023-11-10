package com.munirasapplication.app.modules.doctorscalendar.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.munirasapplication.app.R
import com.munirasapplication.app.databinding.RowListtext1Binding
import com.munirasapplication.app.modules.doctorscalendar.`data`.model.Listtext1RowModel
import kotlin.Int
import kotlin.collections.List

class ListtextAdapter(
  var list: List<Listtext1RowModel>
) : RecyclerView.Adapter<ListtextAdapter.RowListtext1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListtext1VH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listtext1,parent,false)
    return RowListtext1VH(view)
  }

  override fun onBindViewHolder(holder: RowListtext1VH, position: Int) {
    val listtext1RowModel = Listtext1RowModel()
    // TODO uncomment following line after integration with data source
    // val listtext1RowModel = list[position]
    holder.binding.listtext1RowModel = listtext1RowModel
  }

  override fun getItemCount(): Int = 7
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listtext1RowModel>) {
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
      item: Listtext1RowModel
    ) {
    }
  }

  inner class RowListtext1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListtext1Binding = RowListtext1Binding.bind(itemView)
  }
}
