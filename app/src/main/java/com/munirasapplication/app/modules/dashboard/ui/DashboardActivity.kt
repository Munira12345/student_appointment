package com.munirasapplication.app.modules.dashboard.ui

import android.content.Intent
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDashboardBinding
import com.munirasapplication.app.modules.booking.ui.BookingFragment
import com.munirasapplication.app.modules.dashboard.`data`.viewmodel.DashboardVM
import kotlin.String
import kotlin.Unit

class DashboardActivity : BaseActivity<ActivityDashboardBinding>(R.layout.activity_dashboard) {
  private val viewModel: DashboardVM by viewModels<DashboardVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dashboardVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "DASHBOARD_ACTIVITY"



    // this is the button click function i wrote

    val button1 = findViewById<Button>(R.id.button1)
    button1.setOnClickListener {
      val intent = Intent(this,BookingFragment::class.java)
      startActivity(intent)
    }
    /*button1.setOnClickListener { it:View!
      val packageContext = null
      val Intent = Intent( packageContext: this,BookingFragment::class.java)
         startActivity(Intent);
    }; */

  }
}
