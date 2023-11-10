package com.munirasapplication.app.modules.studentcalendar.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ListtextRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtText: String? = MyApp.getInstance().resources.getString(R.string.lbl_06)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_mo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_tu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_we)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_th)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_fr)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextSix: String? = MyApp.getInstance().resources.getString(R.string.lbl_sa)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTextSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl_su)

)
