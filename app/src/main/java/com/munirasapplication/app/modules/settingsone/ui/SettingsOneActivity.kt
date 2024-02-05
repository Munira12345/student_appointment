package com.munirasapplication.app.modules.settingsone.ui

import android.content.Intent
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivitySettingsOneBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.doctorsprofile.ui.DoctorsProfileActivity
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import com.munirasapplication.app.modules.settingsone.`data`.viewmodel.SettingsOneVM
import kotlin.String
import kotlin.Unit

class SettingsOneActivity : BaseActivity<ActivitySettingsOneBinding>(R.layout.activity_settings_one)
    {
  private val viewModel: SettingsOneVM by viewModels<SettingsOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.settingsOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    //home page
    val imageHome= binding.root.findViewById<Button>(R.id.imageHome)
    imageHome.setOnClickListener{
      // handle the button click and navigate to home
      val intent = Intent(this, DoctorsProfileActivity::class.java)
      startActivity(intent)
    }
    // for the settings
    val imageUser= binding.root.findViewById<Button>(R.id.imageUser)
    imageUser.setOnClickListener{
      // handle the button click and navigate to settings
      val intent = Intent(this, SettingsActivity::class.java)
      startActivity(intent)
    }

  }

  companion object {
    const val TAG: String = "SETTINGS_ONE_ACTIVITY"

  }
}
