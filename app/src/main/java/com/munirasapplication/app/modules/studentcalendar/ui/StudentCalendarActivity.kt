package com.munirasapplication.app.modules.studentcalendar.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
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


class StudentCalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_booking)

    val imageHome: ImageView = findViewById(R.id.imageHome)


    imageHome.setOnClickListener {
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
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
