package com.munirasapplication.app.modules.doctorscalendar.ui

import android.view.View
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDoctorsCalendarBinding
import com.munirasapplication.app.modules.doctorscalendar.`data`.model.Listtext1RowModel
import com.munirasapplication.app.modules.doctorscalendar.`data`.viewmodel.DoctorsCalendarVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class DoctorsCalendarActivity :
    BaseActivity<ActivityDoctorsCalendarBinding>(R.layout.activity_doctors_calendar) {
  private val viewModel: DoctorsCalendarVM by viewModels<DoctorsCalendarVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listtextAdapter = ListtextAdapter(viewModel.listtextList.value?:mutableListOf())
    binding.recyclerListtext.adapter = listtextAdapter
    listtextAdapter.setOnItemClickListener(
    object : ListtextAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : Listtext1RowModel) {
        onClickRecyclerListtext(view, position, item)
      }
    }
    )
    viewModel.listtextList.observe(this) {
      listtextAdapter.updateData(it)
    }
    binding.doctorsCalendarVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListtext(
    view: View,
    position: Int,
    item: Listtext1RowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DOCTORS_CALENDAR_ACTIVITY"

  }
}
