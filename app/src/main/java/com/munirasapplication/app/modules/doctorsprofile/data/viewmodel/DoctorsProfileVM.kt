package com.munirasapplication.app.modules.doctorsprofile.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.doctorsprofile.`data`.model.DoctorsProfileModel
import com.munirasapplication.app.modules.doctorsprofile.`data`.model.ListunsplashptrhfmRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class DoctorsProfileVM : ViewModel(), KoinComponent {
  val doctorsProfileModel: MutableLiveData<DoctorsProfileModel> =
      MutableLiveData(DoctorsProfileModel())

  var navArguments: Bundle? = null

  val listunsplashptrhfmList: MutableLiveData<MutableList<ListunsplashptrhfmRowModel>> =
      MutableLiveData(mutableListOf())
}
