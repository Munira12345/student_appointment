package com.munirasapplication.app.modules.studentcalendar.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.studentcalendar.`data`.model.ListtextRowModel
import com.munirasapplication.app.modules.studentcalendar.`data`.model.StudentCalendarModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class StudentCalendarVM : ViewModel(), KoinComponent {
  val studentCalendarModel: MutableLiveData<StudentCalendarModel> =
      MutableLiveData(StudentCalendarModel())

  var navArguments: Bundle? = null

  val listtextList: MutableLiveData<MutableList<ListtextRowModel>> =
      MutableLiveData(mutableListOf())
}
