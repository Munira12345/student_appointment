package com.munirasapplication.app.modules.booking.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseFragment
import com.munirasapplication.app.databinding.FragmentBookingBinding
import com.munirasapplication.app.modules.booking.`data`.model.BookingRowModel
import com.munirasapplication.app.modules.booking.`data`.viewmodel.BookingVM
import com.munirasapplication.app.modules.bookingcontainer.ui.BookingContainerActivity
import com.munirasapplication.app.modules.login.ui.LoginActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit
import android.content.Intent
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity

class BookingFragment : BaseFragment<FragmentBookingBinding>(R.layout.fragment_booking) {
  private val viewModel: BookingVM by viewModels<BookingVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    val bookingAdapter = BookingAdapter(viewModel.bookingList.value?:mutableListOf())
    binding.recyclerBooking.adapter = bookingAdapter
    bookingAdapter.setOnItemClickListener(
    object : BookingAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : BookingRowModel) {
        onClickRecyclerBooking(view, position, item)
      }
    }
    )
    viewModel.bookingList.observe(requireActivity()) {
      bookingAdapter.updateData(it)
    }
    binding.bookingVM = viewModel
  }

  override fun setUpClicks(): Unit {
//added code
    val viewRectangleThirteen = binding.root.findViewById<View>(R.id.viewRectangleThirteen)
    viewRectangleThirteen.setOnClickListener {
      // handle the text view click and navigate to saved
      val intent = Intent(this, BookingContainerActivity::class.java)
      startActivity(intent)
    }
    val btn800Am = binding.root.findViewById<View>(R.id.btn800Am)
    btn800Am.setOnClickListener {
      // handle the text view click and navigate to saved
      val intent = Intent(this, BookingContainerActivity::class.java)
      startActivity(intent)
    }
    val recyclerBooking = binding.root.findViewById<View>(R.id.recyclerBooking)
    recyclerBooking.setOnClickListener {
      // handle the text view click and navigate to saved
      val intent = Intent(this, BookingContainerActivity::class.java)
      startActivity(intent)
    }

    val imagePlus = binding.root.findViewById<View>(R.id.imagePlus)
    imagePlus.setOnClickListener {
      // handle the text view click and navigate to saved
      val intent = Intent(this, BookingContainerActivity::class.java)
      startActivity(intent)
    }
  }

  fun onClickRecyclerBooking(
    view: View,
    position: Int,
    item: BookingRowModel
  ): Unit {
    when(view.id) {
    }
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
