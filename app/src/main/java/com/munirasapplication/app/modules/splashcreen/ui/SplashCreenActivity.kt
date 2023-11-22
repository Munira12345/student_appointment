package com.munirasapplication.app.modules.splashcreen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivitySplashCreenBinding
import com.munirasapplication.app.modules.Registrationa
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
      val destIntent = Intent(this, Registrationa::class.java)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      val button3 = binding.root.findViewById<TextView>(R.id.button3)
      button3.setOnClickListener {
        // handle the text view click and navigate to login activity
        val intent = Intent(this, Registrationa::class.java)
        startActivity(intent)
      }

    }

    companion object {
      const val TAG: String = "SPLASH_CREEN_ACTIVITY"
      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, SplashCreenActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
