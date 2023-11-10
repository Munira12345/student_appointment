package com.munirasapplication.app.modules.dotorschat.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.dotorschat.`data`.model.DotorsChatModel
import org.koin.core.KoinComponent

class DotorsChatVM : ViewModel(), KoinComponent {
  val dotorsChatModel: MutableLiveData<DotorsChatModel> = MutableLiveData(DotorsChatModel())

  var navArguments: Bundle? = null
}
