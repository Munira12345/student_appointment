package com.munirasapplication.app.modules.doctorscalendar.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.doctorscalendar.`data`.model.DoctorsCalendarModel
import com.munirasapplication.app.modules.doctorscalendar.`data`.model.Listtext1RowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class DoctorsCalendarVM : ViewModel(), KoinComponent {
  val doctorsCalendarModel: MutableLiveData<DoctorsCalendarModel> =
      MutableLiveData(DoctorsCalendarModel())

  var navArguments: Bundle? = null

  val listtextList: MutableLiveData<MutableList<Listtext1RowModel>> =
      MutableLiveData(mutableListOf())
}
