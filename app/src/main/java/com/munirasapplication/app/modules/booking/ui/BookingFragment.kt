package com.munirasapplication.app.modules.booking.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseFragment
import com.munirasapplication.app.databinding.FragmentBookingBinding
import com.munirasapplication.app.modules.booking.data.model.BookingRowModel
import com.munirasapplication.app.modules.booking.data.viewmodel.BookingVM
import com.munirasapplication.app.modules.bookingcontainer.ui.BookingContainerActivity
import kotlin.Unit
import android.content.Intent
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity

class BookingFragment : BaseFragment<FragmentBookingBinding>(R.layout.fragment_booking) {
  private val viewModel: BookingVM by viewModels<BookingVM>()

  override fun onInitialized() {
    viewModel.navArguments = arguments

    // Initializing the adapter with an empty list for now
    val bookingAdapter = BookingAdapter(emptyList())
    binding.recyclerBooking.adapter = bookingAdapter

    bookingAdapter.setOnItemClickListener(object : BookingAdapter.OnItemClickListener {
      override fun onItemClick(view: View, position: Int, item: BookingRowModel) {
        onClickRecyclerBooking(view, position, item)
      }
    })

    // Observing changes in the bookingList LiveData and updating the adapter
    viewModel.bookingList.observe(viewLifecycleOwner) {
      bookingAdapter.updateData(it)
    }

    binding.bookingVM = viewModel
  }

  override fun setUpClicks() {
    // Click listener for the "viewRectangleThirteen" view
    binding.viewRectangleThirteen.setOnClickListener {
      navigateToBookingContainerActivity()
    }

    // Similar click listeners for other views
    binding.btn800Am.setOnClickListener {
      navigateToBookingContainerActivity()
    }

    binding.recyclerBooking.setOnClickListener {
      navigateToBookingContainerActivity()
    }

    binding.imagePlus.setOnClickListener {
      navigateToBookingContainerActivity()
    }
  }

  private fun navigateToBookingContainerActivity() {
    // Handle the text view click and navigate to BookingContainerActivity
    val intent = Intent(requireContext(), BookingContainerActivity::class.java)
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

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, BookingFragment::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

