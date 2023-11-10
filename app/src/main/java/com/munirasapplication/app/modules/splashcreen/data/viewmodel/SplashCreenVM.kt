package com.munirasapplication.app.modules.splashcreen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.splashcreen.`data`.model.SplashCreenModel
import org.koin.core.KoinComponent

class SplashCreenVM : ViewModel(), KoinComponent {
  val splashCreenModel: MutableLiveData<SplashCreenModel> = MutableLiveData(SplashCreenModel())

  var navArguments: Bundle? = null
}
