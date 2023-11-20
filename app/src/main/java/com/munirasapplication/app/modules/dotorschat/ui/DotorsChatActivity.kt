package com.munirasapplication.app.modules.dotorschat.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDotorsChatBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.doctorscalendar.ui.DoctorsCalendarActivity
import com.munirasapplication.app.modules.doctorsprofile.ui.DoctorsProfileActivity
import com.munirasapplication.app.modules.dotorschat.`data`.viewmodel.DotorsChatVM
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import com.munirasapplication.app.modules.settingsone.ui.SettingsOneActivity
import com.munirasapplication.app.modules.studentcalendar.ui.StudentCalendarActivity
import kotlin.String
import kotlin.Unit

class DotorsChatActivity : BaseActivity<ActivityDotorsChatBinding>(R.layout.activity_dotors_chat) {
  private val viewModel: DotorsChatVM by viewModels<DotorsChatVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dotorsChatVM = viewModel
  }

  override fun setUpClicks(): Unit {

    // for the home
    val linearRowhome = binding.root.findViewById<Button>(R.id.linearRowhome)
    linearRowhome.setOnClickListener {
      // handle the button click and navigate to home
      val intent = Intent(this, DoctorsProfileActivity::class.java)
      startActivity(intent)
    }

    // for the calendar
    val imageCalendar = binding.root.findViewById<Button>(R.id.imageCalendar)
    imageCalendar.setOnClickListener {
      // handle the button click and navigate to doctors calendar
      val intent = Intent(this, DoctorsCalendarActivity::class.java)
      startActivity(intent)
    }

    // for the settings za student
    val imageUser = binding.root.findViewById<Button>(R.id.imageUser)
    imageUser.setOnClickListener {
      // handle the button click and navigate to settings
      val intent = Intent(this, SettingsOneActivity::class.java)
      startActivity(intent)
    }

  }
  companion object {
    const val TAG: String = "DOTORS_CHAT_ACTIVITY"
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DotorsChatActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
