package com.munirasapplication.app.modules.patientrequests.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.patientrequests.`data`.model.Listunsplashptrhfm1RowModel
import com.munirasapplication.app.modules.patientrequests.`data`.model.PatientRequestsModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class PatientRequestsVM : ViewModel(), KoinComponent {
  val patientRequestsModel: MutableLiveData<PatientRequestsModel> =
      MutableLiveData(PatientRequestsModel())

  var navArguments: Bundle? = null

  val listunsplashptrhfmList: MutableLiveData<MutableList<Listunsplashptrhfm1RowModel>> =
      MutableLiveData(mutableListOf())
}
