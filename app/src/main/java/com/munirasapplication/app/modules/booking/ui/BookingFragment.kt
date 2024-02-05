package com.munirasapplication.app.modules.booking.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseFragment
import com.munirasapplication.app.databinding.FragmentBookingBinding
import com.munirasapplication.app.modules.booking.data.model.BookingRowModel
import com.munirasapplication.app.modules.booking.data.viewmodel.BookingVM
import com.munirasapplication.app.modules.doctorsprofile.ui.DoctorsProfileActivity

class BookingFragment : BaseFragment<FragmentBookingBinding>(R.layout.fragment_booking) {
  private val viewModel: BookingVM by viewModels<BookingVM>()

  override fun onInitialized() {
    viewModel.navArguments = arguments

    // Initializing the adapter with an empty list for now
    val bookingAdapter = BookingAdapter(emptyList())
    binding.recyclerBooking.adapter = bookingAdapter
  }

  override fun setUpClicks() {
    // Click listener for the "viewRectangleThirteen" view
    binding.viewRectangleThirteen.setOnClickListener {
      navigateToDoctorsProfileActivity()
    }

    // Similar click listeners for other views
    binding.btn800Am.setOnClickListener {
      navigateToDoctorsProfileActivity()
    }

    binding.recyclerBooking.setOnClickListener {
      navigateToDoctorsProfileActivity()
    }

    binding.imagePlus.setOnClickListener {
      navigateToDoctorsProfileActivity()
    }
  }

  private fun navigateToDoctorsProfileActivity() {
    val intent = DoctorsProfileActivity.getIntent(requireContext(), arguments)
    startActivity(intent)
  }

  private fun onClickRecyclerBooking(view: View, position: Int, item: BookingRowModel) {
    // Handle click events on the recycler view item if needed
    // (You can add code here based on the specific item clicked)
  }

  companion object {
    const val TAG: String = "BOOKING_FRAGMENT"

    fun getInstance(bundle: Bundle?): BookingFragment {
      val fragment = BookingFragment()
      fragment.arguments = bundle
      return fragment
    }

    fun getIntent(context: Context, bundle: Bundle?): android.content.Intent {
      val destIntent = android.content.Intent(context, BookingFragment::class.java)
      bundle?.let { destIntent.putExtra("bundle", it) }
      return destIntent
    }

  }
}
