package com.munirasapplication.app.modules.studentschat.ui

import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityStudentsChatBinding
import com.munirasapplication.app.modules.studentschat.`data`.viewmodel.StudentsChatVM
import kotlin.String
import kotlin.Unit

class StudentsChatActivity :
    BaseActivity<ActivityStudentsChatBinding>(R.layout.activity_students_chat) {
  private val viewModel: StudentsChatVM by viewModels<StudentsChatVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.studentsChatVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "STUDENTS_CHAT_ACTIVITY"

  }
}
