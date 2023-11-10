package com.munirasapplication.app.modules.studentschat.`data`.model

import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class StudentsChatModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_30_pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSoremipsumdol: String? =
      MyApp.getInstance().resources.getString(R.string.msg_sorem_ipsum_dol)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLorem: String? = MyApp.getInstance().resources.getString(R.string.lbl_lorem)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBoremipsumdol: String? =
      MyApp.getInstance().resources.getString(R.string.msg_borem_ipsum_dol)

)
