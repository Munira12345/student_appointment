package com.munirasapplication.app.modules.doctorscalendar.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDoctorsCalendarBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.doctorscalendar.`data`.model.Listtext1RowModel
import com.munirasapplication.app.modules.doctorscalendar.`data`.viewmodel.DoctorsCalendarVM
import com.munirasapplication.app.modules.doctorsprofile.ui.DoctorsProfileActivity
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import com.munirasapplication.app.modules.settingsone.ui.SettingsOneActivity
import com.munirasapplication.app.modules.studentschat.ui.StudentsChatActivity
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


    //home page
    val imageHome= binding.root.findViewById<Button>(R.id.imageHome)
    imageHome.setOnClickListener{
      // handle the button click and navigate to profile
      val intent = Intent(this, DoctorsProfileActivity::class.java)
      startActivity(intent)
    }
    // for the chat
    val imageSignalOne= binding.root.findViewById<Button>(R.id.imageSignalOne)
    imageSignalOne.setOnClickListener{
      // handle the button click and navigate to doctor chat
      val intent = Intent(this, StudentsChatActivity::class.java)
      startActivity(intent)
    }
    // for the settings za student
    val imageUser= binding.root.findViewById<Button>(R.id.imageUser)
    imageUser.setOnClickListener{
      // handle the button click and navigate to doctor settings
      val intent = Intent(this, SettingsOneActivity::class.java)
      startActivity(intent)
    }

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
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DoctorsCalendarActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
