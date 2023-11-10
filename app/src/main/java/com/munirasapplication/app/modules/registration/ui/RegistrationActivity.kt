package com.munirasapplication.app.modules.registration.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityRegistrationBinding
import com.munirasapplication.app.modules.registration.`data`.viewmodel.RegistrationVM
import kotlin.String
import kotlin.Unit

class RegistrationActivity :
    BaseActivity<ActivityRegistrationBinding>(R.layout.activity_registration) {
  private val viewModel: RegistrationVM by viewModels<RegistrationVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registrationVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "REGISTRATION_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegistrationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
