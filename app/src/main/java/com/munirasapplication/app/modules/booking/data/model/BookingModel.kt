package com.munirasapplication.app.modules.booking.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class BookingModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_30_pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBookyourconve: String? =
      MyApp.getInstance().resources.getString(R.string.msg_book_your_conve)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAvailabletime: String? =
      MyApp.getInstance().resources.getString(R.string.msg_available_time)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_9_00_am)

)
