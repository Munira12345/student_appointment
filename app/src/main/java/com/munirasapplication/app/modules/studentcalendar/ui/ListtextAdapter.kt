package com.munirasapplication.app.modules.studentcalendar.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.munirasapplication.app.R
import com.munirasapplication.app.databinding.RowListtextBinding
import com.munirasapplication.app.modules.studentcalendar.`data`.model.ListtextRowModel
import kotlin.Int
import kotlin.collections.List

class ListtextAdapter(
  var list: List<ListtextRowModel>
) : RecyclerView.Adapter<ListtextAdapter.RowListtextVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListtextVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listtext,parent,false)
    return RowListtextVH(view)
  }

  override fun onBindViewHolder(holder: RowListtextVH, position: Int) {
    val listtextRowModel = ListtextRowModel()
    // TODO uncomment following line after integration with data source
    // val listtextRowModel = list[position]
    holder.binding.listtextRowModel = listtextRowModel
  }

  override fun getItemCount(): Int = 7
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListtextRowModel>) {
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
      item: ListtextRowModel
    ) {
    }
  }

  inner class RowListtextVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListtextBinding = RowListtextBinding.bind(itemView)
  }
}
