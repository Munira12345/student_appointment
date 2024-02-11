package com.munirasapplication.app.modules.doctorscalendar.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDoctorsCalendarBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.doctorscalendar.`data`.model.Listtext1RowModel
import com.munirasapplication.app.modules.doctorscalendar.`data`.viewmodel.DoctorsCalendarVM
import com.munirasapplication.app.modules.doctorsprofile.ui.DoctorsProfileActivity
import com.munirasapplication.app.modules.settings.ui.SettingsActivity
import com.munirasapplication.app.modules.settingsone.ui.SettingsOneActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class DoctorsCalendarActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_doctors_calendar)


    val imageHome: ImageView = findViewById(R.id.imageHome)


    imageHome.setOnClickListener {
      val intent = Intent(this, DoctorsProfileActivity::class.java)
      startActivity(intent)
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
