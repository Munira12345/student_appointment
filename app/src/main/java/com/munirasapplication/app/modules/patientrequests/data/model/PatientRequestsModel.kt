package com.munirasapplication.app.modules.patientrequests.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class PatientRequestsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_30_pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGoodmorningFra: String? =
      MyApp.getInstance().resources.getString(R.string.msg_goodmorning_fra)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_appointments_re)

)
