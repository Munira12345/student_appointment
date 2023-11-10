package com.munirasapplication.app.modules.studentschat.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.studentschat.`data`.model.StudentsChatModel
import org.koin.core.KoinComponent

class StudentsChatVM : ViewModel(), KoinComponent {
  val studentsChatModel: MutableLiveData<StudentsChatModel> = MutableLiveData(StudentsChatModel())

  var navArguments: Bundle? = null
}
