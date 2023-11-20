package com.munirasapplication.app.modules.doctorsprofile.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDoctorsProfileBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.doctorsprofile.`data`.model.ListunsplashptrhfmRowModel
import com.munirasapplication.app.modules.doctorsprofile.`data`.viewmodel.DoctorsProfileVM
import com.munirasapplication.app.modules.dotorschat.ui.DotorsChatActivity
import com.munirasapplication.app.modules.patientrequests.ui.PatientRequestsActivity
import com.munirasapplication.app.modules.registration.ui.RegistrationActivity
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import com.munirasapplication.app.modules.settingsone.ui.SettingsOneActivity
import com.munirasapplication.app.modules.studentcalendar.ui.StudentCalendarActivity
import com.munirasapplication.app.modules.studentschat.ui.StudentsChatActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class DoctorsProfileActivity :
    BaseActivity<ActivityDoctorsProfileBinding>(R.layout.activity_doctors_profile) {
  private val viewModel: DoctorsProfileVM by viewModels<DoctorsProfileVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listunsplashptrhfmAdapter =
    ListunsplashptrhfmAdapter(viewModel.listunsplashptrhfmList.value?:mutableListOf())
    binding.recyclerListunsplashptrhfm.adapter = listunsplashptrhfmAdapter
    listunsplashptrhfmAdapter.setOnItemClickListener(
    object : ListunsplashptrhfmAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListunsplashptrhfmRowModel) {
        onClickRecyclerListunsplashptrhfm(view, position, item)
      }
    }
    )
    viewModel.listunsplashptrhfmList.observe(this) {
      listunsplashptrhfmAdapter.updateData(it)
    }
    binding.doctorsProfileVM = viewModel
  }

  override fun setUpClicks(): Unit {

    //clicks
    val button2 = binding.root.findViewById<Button>(R.id.button2)
    button2.setOnClickListener{
      // handle the button click and navigate to the patients requests activity
      val intent = Intent(this, PatientRequestsActivity::class.java)
      startActivity(intent)
    }
// for the calendar
    val imageCalendar= binding.root.findViewById<Button>(R.id.imageCalendar)
    imageCalendar.setOnClickListener{
      // handle the button click and navigate to calendar
      val intent = Intent(this, StudentCalendarActivity::class.java)
      startActivity(intent)
    }
    // for the chat
    val imageSignalOne= binding.root.findViewById<Button>(R.id.imageSignalOne)
    imageSignalOne.setOnClickListener{
      // handle the button click and navigate to chat
      val intent = Intent(this, DotorsChatActivity::class.java)
      startActivity(intent)
    }
    // for the settings za student
    val imageUser= binding.root.findViewById<Button>(R.id.imageUser)
    imageUser.setOnClickListener{
      // handle the button click and navigate to settings
      val intent = Intent(this, SettingsOneActivity::class.java)
      startActivity(intent)
    }


  }

  fun onClickRecyclerListunsplashptrhfm(
    view: View,
    position: Int,
    item: ListunsplashptrhfmRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DOCTORS_PROFILE_ACTIVITY"


    //added code
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DoctorsProfileActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
