package com.munirasapplication.app.modules.patientrequests.ui

import android.view.View
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityPatientRequestsBinding
import com.munirasapplication.app.modules.patientrequests.`data`.model.Listunsplashptrhfm1RowModel
import com.munirasapplication.app.modules.patientrequests.`data`.viewmodel.PatientRequestsVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class PatientRequestsActivity :
    BaseActivity<ActivityPatientRequestsBinding>(R.layout.activity_patient_requests) {
  private val viewModel: PatientRequestsVM by viewModels<PatientRequestsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listunsplashptrhfmAdapter =
    ListunsplashptrhfmAdapter(viewModel.listunsplashptrhfmList.value?:mutableListOf())
    binding.recyclerListunsplashptrhfm.adapter = listunsplashptrhfmAdapter
    listunsplashptrhfmAdapter.setOnItemClickListener(
    object : ListunsplashptrhfmAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listunsplashptrhfm1RowModel) {
        onClickRecyclerListunsplashptrhfm(view, position, item)
      }
    }
    )
    viewModel.listunsplashptrhfmList.observe(this) {
      listunsplashptrhfmAdapter.updateData(it)
    }
    binding.patientRequestsVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListunsplashptrhfm(
    view: View,
    position: Int,
    item: Listunsplashptrhfm1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PATIENT_REQUESTS_ACTIVITY"

  }
}
