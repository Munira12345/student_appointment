package com.munirasapplication.app.modules.splashcreen.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class SplashCreenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_30_pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_all_your_medica)
  ,
  /**
   * TODO Replace with dynamic value

  var txtDescription: String? =
   *   MyApp.getInstance().resources.getString(R.string.msg_yorem_ipsum_dol)
*/
)
