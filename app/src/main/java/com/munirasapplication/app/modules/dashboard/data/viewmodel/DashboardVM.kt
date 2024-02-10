package com.munirasapplication.app.modules.dashboard.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munirasapplication.app.modules.dashboard.`data`.model.DashboardModel
import org.koin.core.KoinComponent

class DashboardVM : ViewModel(), KoinComponent {
  val dashboardModel: MutableLiveData<DashboardModel> = MutableLiveData(DashboardModel())
  val appointmentDetails: MutableLiveData<String> = MutableLiveData()

  // Function to update appointment details
  fun updateAppointmentDetails(details: String) {
    appointmentDetails.value = details
  }

  var navArguments: Bundle? = null


}