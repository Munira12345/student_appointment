package com.munirasapplication.app.modules.bookingcontainer.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.bookingcontainer.`data`.model.BookingContainerModel
import org.koin.core.KoinComponent

class BookingContainerVM : ViewModel(), KoinComponent {
  val bookingContainerModel: MutableLiveData<BookingContainerModel> =
      MutableLiveData(BookingContainerModel())

  var navArguments: Bundle? = null
}
