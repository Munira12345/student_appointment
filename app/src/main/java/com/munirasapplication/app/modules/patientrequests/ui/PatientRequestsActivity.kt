package com.munirasapplication.app.modules.patientrequests.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityPatientRequestsBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.doctorscalendar.ui.DoctorsCalendarActivity
import com.munirasapplication.app.modules.doctorsprofile.ui.DoctorsProfileActivity
import com.munirasapplication.app.modules.patientrequests.`data`.model.Listunsplashptrhfm1RowModel
import com.munirasapplication.app.modules.patientrequests.`data`.viewmodel.PatientRequestsVM
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import com.munirasapplication.app.modules.settingsone.ui.SettingsOneActivity
import com.munirasapplication.app.modules.studentcalendar.ui.StudentCalendarActivity
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

    // for the calendar
    val imageHome= binding.root.findViewById<Button>(R.id.imageHome)
    imageHome.setOnClickListener{
      // handle the button click and navigate to doctor profile
      val intent = Intent(this, DoctorsProfileActivity::class.java)
      startActivity(intent)
    }

    // for the calendar
    val imageCalendar= binding.root.findViewById<Button>(R.id.imageCalendar)
    imageCalendar.setOnClickListener{
      // handle the button click and navigate to doctor calendar
      val intent = Intent(this, DoctorsCalendarActivity::class.java)
      startActivity(intent)
    }

    // for the settings za student
    val imageUser= binding.root.findViewById<Button>(R.id.imageUser)
    imageUser.setOnClickListener{
      // handle the button click and navigate to doctors settings
      val intent = Intent(this, SettingsOneActivity::class.java)
      startActivity(intent)
    }
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
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DashboardActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
