package com.munirasapplication.app.modules.studentcalendar.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityStudentCalendarBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
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

    //home page
    val imageHome= binding.root.findViewById<Button>(R.id.imageHome)
    imageHome.setOnClickListener{
      // handle the button click and navigate to studentcalendar
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }
    // for the settings za student
    val imageUser= binding.root.findViewById<Button>(R.id.imageUser)
    imageUser.setOnClickListener{
      // handle the button click and navigate to settings
      val intent = Intent(this, SettingsActivity::class.java)
      startActivity(intent)
    }

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

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, StudentCalendarActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
