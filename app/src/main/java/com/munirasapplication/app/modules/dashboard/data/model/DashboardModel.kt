package com.munirasapplication.app.modules.dashboard.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class DashboardModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_30_pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGoodmorningian: String? =
      MyApp.getInstance().resources.getString(R.string.msg_goodmorning_ian)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYouhaveoneup: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_have_one_up)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrancisSktelz: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_francis_sktelz)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_12_10pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBookAppointmen: String? =
      MyApp.getInstance().resources.getString(R.string.msg_book_appointmen)

)
