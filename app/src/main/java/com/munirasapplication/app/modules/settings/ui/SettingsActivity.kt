package com.munirasapplication.app.modules.settings.ui

import android.content.Intent
import android.widget.Button
import androidx.activity.viewModels
import android.content.Context
import android.os.Bundle
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivitySettingsBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.settings.`data`.viewmodel.SettingsVM
import com.munirasapplication.app.modules.studentcalendar.ui.StudentCalendarActivity
import com.munirasapplication.app.modules.studentschat.ui.StudentsChatActivity
import kotlin.String
import kotlin.Unit

class SettingsActivity : BaseActivity<ActivitySettingsBinding>(R.layout.activity_settings) {
  private val viewModel: SettingsVM by viewModels<SettingsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.settingsVM = viewModel
  }

  override fun setUpClicks(): Unit {


    //all the menu navigations
    //for the image home


    val imageHome = binding.root.findViewById<Button>(R.id.imageHome)
    imageHome.setOnClickListener {
      // handle the button click and navigate to dashboard
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }
    // for the calendar
    val imageCalendar = binding.root.findViewById<Button>(R.id.imageCalendar)
    imageCalendar.setOnClickListener {
      // handle the button click and navigate to studentcalendar
      val intent = Intent(this, StudentCalendarActivity::class.java)
      startActivity(intent)
    }
    // for the chat
    val imageSignalOne = binding.root.findViewById<Button>(R.id.imageSignalOne)
    imageSignalOne.setOnClickListener {
      // handle the button click and navigate to studentchat
      val intent = Intent(this, StudentsChatActivity::class.java)
      startActivity(intent)
    }

  }
  companion object {
    const val TAG: String = "SETTINGS_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SettingsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
