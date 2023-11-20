package com.munirasapplication.app.modules.bookingcontainer.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityBookingContainerBinding
import com.munirasapplication.app.extensions.loadFragment
import com.munirasapplication.app.modules.booking.ui.BookingFragment
import com.munirasapplication.app.modules.bookingcontainer.`data`.viewmodel.BookingContainerVM
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import kotlin.String
import kotlin.Unit

class BookingContainerActivity :
    BaseActivity<ActivityBookingContainerBinding>(R.layout.activity_booking_container) {
  private val viewModel: BookingContainerVM by viewModels<BookingContainerVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.bookingContainerVM = viewModel
    val destFragment = BookingFragment.getInstance(null)
    this.loadFragment(
        R.id.fragmentContainer,
        destFragment,
        bundle = destFragment.arguments, 
        tag = BookingFragment.TAG, 
        addToBackStack = false, 
        add = false, 
        enter = null, 
        exit = null, 
        )
  }

  override fun setUpClicks(): Unit {
    binding.imageHome.setOnClickListener {
      val destFragment = BookingFragment.getInstance(null)
      this.loadFragment(
          R.id.fragmentContainer,
          destFragment,
          bundle = destFragment.arguments, 
          tag = BookingFragment.TAG, 
          addToBackStack = true, 
          add = false, 
          enter = null, 
          exit = null, 
          )
    }

      val imageHome= binding.root.findViewById<Button>(R.id.imageHome)
      imageHome.setOnClickListener{
          // handle the button click and navigate to home page
          val intent = Intent(this, DashboardActivity::class.java)
          startActivity(intent)
      }

  }

  companion object {
    const val TAG: String = "BOOKING_CONTAINER_ACTIVITY"

      fun getIntent(context: Context, bundle: Bundle?): Intent {
          val destIntent = Intent(context, BookingContainerActivity::class.java)
          destIntent.putExtra("bundle", bundle)
          return destIntent
      }

  }
}
