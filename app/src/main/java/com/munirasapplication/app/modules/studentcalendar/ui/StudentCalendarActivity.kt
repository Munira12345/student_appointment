package com.munirasapplication.app.modules.studentcalendar.ui

import android.view.View
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityStudentCalendarBinding
import com.munirasapplication.app.modules.studentcalendar.`data`.model.ListtextRowModel
import com.munirasapplication.app.modules.studentcalendar.`data`.viewmodel.StudentCalendarVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class StudentCalendarActivity :
    BaseActivity<ActivityStudentCalendarBinding>(R.layout.activity_student_calendar) {
  private val viewModel: StudentCalendarVM by viewModels<StudentCalendarVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listtextAdapter = ListtextAdapter(viewModel.listtextList.value?:mutableListOf())
    binding.recyclerListtext.adapter = listtextAdapter
    listtextAdapter.setOnItemClickListener(
    object : ListtextAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListtextRowModel) {
        onClickRecyclerListtext(view, position, item)
      }
    }
    )
    viewModel.listtextList.observe(this) {
      listtextAdapter.updateData(it)
    }
    binding.studentCalendarVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListtext(
    view: View,
    position: Int,
    item: ListtextRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "STUDENT_CALENDAR_ACTIVITY"

  }
}
