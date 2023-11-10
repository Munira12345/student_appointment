package com.munirasapplication.app.modules.settingsone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.settingsone.`data`.model.SettingsOneModel
import org.koin.core.KoinComponent

class SettingsOneVM : ViewModel(), KoinComponent {
  val settingsOneModel: MutableLiveData<SettingsOneModel> = MutableLiveData(SettingsOneModel())

  var navArguments: Bundle? = null
}
