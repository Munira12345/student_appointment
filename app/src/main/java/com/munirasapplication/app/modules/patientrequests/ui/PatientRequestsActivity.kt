package com.munirasapplication.app.modules.patientrequests.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityPatientRequestsBinding
import com.munirasapplication.app.modules.doctorscalendar.ui.DoctorsCalendarActivity
import com.munirasapplication.app.modules.doctorsprofile.ui.DoctorsProfileActivity
import com.munirasapplication.app.modules.patientrequests.data.model.Listunsplashptrhfm1RowModel
import com.munirasapplication.app.modules.patientrequests.data.viewmodel.PatientRequestsVM
import com.munirasapplication.app.modules.settingsone.ui.SettingsOneActivity

class PatientRequestsActivity :
  BaseActivity<ActivityPatientRequestsBinding>(R.layout.activity_patient_requests) {

  private val viewModel: PatientRequestsVM by viewModels()

  override fun onInitialized() {
    val listunsplashptrhfmAdapter = ListunsplashptrhfmAdapter(viewModel.listunsplashptrhfmList.value ?: mutableListOf())
    binding.recyclerListunsplashptrhfm.apply {
      adapter = listunsplashptrhfmAdapter
      layoutManager = LinearLayoutManager(this@PatientRequestsActivity)
    }
    listunsplashptrhfmAdapter.setOnItemClickListener(object : ListunsplashptrhfmAdapter.OnItemClickListener {
      override fun onItemClick(view: View, position: Int, item: Listunsplashptrhfm1RowModel) {
        // Handle item click event
      }
    })
    viewModel.listunsplashptrhfmList.observe(this) {
      listunsplashptrhfmAdapter.updateData(it)
    }
    binding.patientRequestsVM = viewModel
  }

  override fun setUpClicks() {
    // Handle clicks for different buttons

    binding.imageHome.setOnClickListener {
      navigateToDoctorsProfileActivity()
    }

    binding.imageCalendar.setOnClickListener {
      navigateToDoctorsCalendarActivity()
    }

    binding.imageUser.setOnClickListener {
      navigateToSettingsOneActivity()
    }
  }

  private fun navigateToDoctorsProfileActivity() {
    val intent = Intent(this, DoctorsProfileActivity::class.java)
    startActivity(intent)
  }

  private fun navigateToDoctorsCalendarActivity() {
    val intent = Intent(this, DoctorsCalendarActivity::class.java)
    startActivity(intent)
  }

  private fun navigateToSettingsOneActivity() {
    val intent = Intent(this, SettingsOneActivity::class.java)
    startActivity(intent)
  }

  companion object {
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PatientRequestsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
