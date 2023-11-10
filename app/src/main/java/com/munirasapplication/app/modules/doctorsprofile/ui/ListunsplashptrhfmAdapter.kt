package com.munirasapplication.app.modules.doctorsprofile.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.munirasapplication.app.R
import com.munirasapplication.app.databinding.RowListunsplashptrhfmBinding
import com.munirasapplication.app.modules.doctorsprofile.`data`.model.ListunsplashptrhfmRowModel
import kotlin.Int
import kotlin.collections.List

class ListunsplashptrhfmAdapter(
  var list: List<ListunsplashptrhfmRowModel>
) : RecyclerView.Adapter<ListunsplashptrhfmAdapter.RowListunsplashptrhfmVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListunsplashptrhfmVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listunsplashptrhfm,parent,false)
    return RowListunsplashptrhfmVH(view)
  }

  override fun onBindViewHolder(holder: RowListunsplashptrhfmVH, position: Int) {
    val listunsplashptrhfmRowModel = ListunsplashptrhfmRowModel()
    // TODO uncomment following line after integration with data source
    // val listunsplashptrhfmRowModel = list[position]
    holder.binding.listunsplashptrhfmRowModel = listunsplashptrhfmRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListunsplashptrhfmRowModel>) {
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
      item: ListunsplashptrhfmRowModel
    ) {
    }
  }

  inner class RowListunsplashptrhfmVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListunsplashptrhfmBinding = RowListunsplashptrhfmBinding.bind(itemView)
  }
}
