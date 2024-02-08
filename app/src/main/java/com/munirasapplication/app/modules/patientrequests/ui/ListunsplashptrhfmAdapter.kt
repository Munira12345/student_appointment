package com.munirasapplication.app.modules.patientrequests.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.munirasapplication.app.R
import com.munirasapplication.app.databinding.RowListunsplashptrhfm1Binding
import com.munirasapplication.app.modules.patientrequests.data.model.Listunsplashptrhfm1RowModel

class ListunsplashptrhfmAdapter(
  var list: List<Listunsplashptrhfm1RowModel>
) : RecyclerView.Adapter<ListunsplashptrhfmAdapter.RowListunsplashptrhfm1VH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListunsplashptrhfm1VH {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.row_listunsplashptrhfm1, parent, false)
    return RowListunsplashptrhfm1VH(view)
  }

  override fun onBindViewHolder(holder: RowListunsplashptrhfm1VH, position: Int) {
    val listunsplashptrhfm1RowModel = list[position]
    holder.binding.listunsplashptrhfm1RowModel = listunsplashptrhfm1RowModel
  }

  override fun getItemCount(): Int = list.size

  fun updateData(newData: List<Listunsplashptrhfm1RowModel>) {
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
      item: Listunsplashptrhfm1RowModel
    )
  }

  inner class RowListunsplashptrhfm1VH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListunsplashptrhfm1Binding = RowListunsplashptrhfm1Binding.bind(itemView)
  }
}
