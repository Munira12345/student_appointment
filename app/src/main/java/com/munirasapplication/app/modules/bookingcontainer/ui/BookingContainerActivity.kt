package com.munirasapplication.app.modules.bookingcontainer.ui

import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityBookingContainerBinding
import com.munirasapplication.app.extensions.loadFragment
import com.munirasapplication.app.modules.booking.ui.BookingFragment
import com.munirasapplication.app.modules.bookingcontainer.`data`.viewmodel.BookingContainerVM
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
  }

  companion object {
    const val TAG: String = "BOOKING_CONTAINER_ACTIVITY"

  }
}
