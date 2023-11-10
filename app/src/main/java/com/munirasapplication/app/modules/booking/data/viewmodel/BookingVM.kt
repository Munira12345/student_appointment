package com.munirasapplication.app.modules.booking.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.booking.`data`.model.BookingModel
import com.munirasapplication.app.modules.booking.`data`.model.BookingRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class BookingVM : ViewModel(), KoinComponent {
  val bookingModel: MutableLiveData<BookingModel> = MutableLiveData(BookingModel())

  var navArguments: Bundle? = null

  val bookingList: MutableLiveData<MutableList<BookingRowModel>> = MutableLiveData(mutableListOf())
}
