package com.munirasapplication.app.modules.studentschat.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityStudentsChatBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import com.munirasapplication.app.modules.studentcalendar.ui.StudentCalendarActivity
import com.munirasapplication.app.modules.studentschat.`data`.viewmodel.StudentsChatVM
import kotlin.String
import kotlin.Unit

class StudentsChatActivity :
    BaseActivity<ActivityStudentsChatBinding>(R.layout.activity_students_chat) {
  private val viewModel: StudentsChatVM by viewModels<StudentsChatVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.studentsChatVM = viewModel
  }

  override fun setUpClicks(): Unit {

    // for the home
    val imageHome= binding.root.findViewById<Button>(R.id.imageHome)
    imageHome.setOnClickListener{
      // handle the button click and navigate to studentcalendar
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }
    // for the calendar
    val imageCalendar= binding.root.findViewById<Button>(R.id.imageCalendar)
    imageCalendar.setOnClickListener{
      // handle the button click and navigate to studentcalendar
      val intent = Intent(this, StudentCalendarActivity::class.java)
      startActivity(intent)
    }
        // for the settings za student
    val imageUser= binding.root.findViewById<Button>(R.id.imageUser)
    imageUser.setOnClickListener{
      // handle the button click and navigate to settings
      val intent = Intent(this, SettingsActivity::class.java)
      startActivity(intent)
    }
  }

  companion object {
    const val TAG: String = "STUDENTS_CHAT_ACTIVITY"
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, StudentsChatActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
