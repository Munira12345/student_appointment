package com.munirasapplication.app.modules.registration.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class RegistrationModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_30_pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcomeOnBoard: String? =
      MyApp.getInstance().resources.getString(R.string.msg_welcome_onboard)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGetmedicalass: String? =
      MyApp.getInstance().resources.getString(R.string.msg_get_medical_ass)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_already_have_an)

)
