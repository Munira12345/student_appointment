package com.munirasapplication.app.modules.settingsone.ui

import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivitySettingsOneBinding
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
  }

  companion object {
    const val TAG: String = "SETTINGS_ONE_ACTIVITY"

  }
}
