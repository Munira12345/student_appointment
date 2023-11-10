package com.munirasapplication.app.modules.splashcreen.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivitySplashCreenBinding
import com.munirasapplication.app.modules.registration.ui.RegistrationActivity
import com.munirasapplication.app.modules.splashcreen.`data`.viewmodel.SplashCreenVM
import kotlin.String
import kotlin.Unit

class SplashCreenActivity : BaseActivity<ActivitySplashCreenBinding>(R.layout.activity_splash_creen)
    {
  private val viewModel: SplashCreenVM by viewModels<SplashCreenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashCreenVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = RegistrationActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
    }

    companion object {
      const val TAG: String = "SPLASH_CREEN_ACTIVITY"

    }
  }
