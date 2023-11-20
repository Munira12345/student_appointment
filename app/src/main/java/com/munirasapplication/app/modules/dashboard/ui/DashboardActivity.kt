package com.munirasapplication.app.modules.dashboard.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDashboardBinding
import com.munirasapplication.app.modules.booking.ui.BookingFragment
import com.munirasapplication.app.modules.dashboard.`data`.viewmodel.DashboardVM
import com.munirasapplication.app.modules.login.ui.LoginActivity
import kotlin.String
import kotlin.Unit
import androidx.core.content.ContextCompat.startActivity
import com.munirasapplication.app.modules.registration.ui.RegistrationActivity
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import com.munirasapplication.app.modules.studentcalendar.ui.StudentCalendarActivity
import com.munirasapplication.app.modules.studentschat.ui.StudentsChatActivity

class DashboardActivity : BaseActivity<ActivityDashboardBinding>(R.layout.activity_dashboard) {
  private val viewModel: DashboardVM by viewModels<DashboardVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dashboardVM = viewModel
  }

  override fun setUpClicks(): Unit {
    // added code
    val button1 = binding.root.findViewById<Button>(R.id.button1)
    button1.setOnClickListener{
      // handle the button click and navigate to booking fragment
      val intent = Intent(this, BookingFragment::class.java)
      startActivity(intent)
    }

   //all the menu Navigations

    // for the calendar
    val imageCalendar= binding.root.findViewById<Button>(R.id.imageCalendar)
    imageCalendar.setOnClickListener{
      // handle the button click and navigate to student-calendar
      val intent = Intent(this, StudentCalendarActivity::class.java)
      startActivity(intent)
    }
    // for the chat
    val imageSignalOne= binding.root.findViewById<Button>(R.id.imageSignalOne)
    imageSignalOne.setOnClickListener{
      // handle the button click and navigate to student chat
      val intent = Intent(this, StudentsChatActivity::class.java)
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
    const val TAG: String = "DASHBOARD_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DashboardActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  } }



