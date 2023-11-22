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
import com.munirasapplication.app.modules.bookingcontainer.data.viewmodel.BookingContainerVM
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity

class BookingContainerActivity :
    BaseActivity<ActivityBookingContainerBinding>(R.layout.activity_booking_container) {

    private val viewModel: BookingContainerVM by viewModels()

    override fun onInitialized() {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.bookingContainerVM = viewModel

        // Load the initial fragment (BookingFragment)
        loadBookingFragment()
    }

    override fun setUpClicks() {
        // Click listener for the home button in the activity
        binding.imageHome.setOnClickListener {
            loadBookingFragment()
        }

        // Example: Click listener for a button inside the fragment (imageHome)
        val imageHomeButton = binding.root.findViewById<Button>(R.id.imageHome)
        imageHomeButton.setOnClickListener {
            navigateToDashboard()
        }
    }

    private fun loadBookingFragment() {
        // Load the BookingFragment into the fragment container
        loadFragment(
            R.id.fragmentContainer,
            BookingFragment.getInstance(null),
            tag = BookingFragment.TAG,
            addToBackStack = true,
            add = false,
            enter = null,
            exit = null
        )
    }

    private fun navigateToDashboard() {
        // Handle the button click and navigate to the DashboardActivity
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val TAG: String = "BOOKING_CONTAINER_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            return Intent(context, BookingContainerActivity::class.java).apply {
                putExtra("bundle", bundle)
            }
        }
    }
}
