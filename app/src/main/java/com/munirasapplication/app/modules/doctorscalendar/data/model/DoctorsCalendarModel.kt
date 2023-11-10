package com.munirasapplication.app.modules.doctorscalendar.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class DoctorsCalendarModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_30_pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyCalendar: String? = MyApp.getInstance().resources.getString(R.string.lbl_my_calendar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrancisSktelz: String? = MyApp.getInstance().resources.getString(R.string.lbl_mary_nena2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_8_10am)

)
