package com.munirasapplication.app.modules.dotorschat.ui

import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDotorsChatBinding
import com.munirasapplication.app.modules.dotorschat.`data`.viewmodel.DotorsChatVM
import kotlin.String
import kotlin.Unit

class DotorsChatActivity : BaseActivity<ActivityDotorsChatBinding>(R.layout.activity_dotors_chat) {
  private val viewModel: DotorsChatVM by viewModels<DotorsChatVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dotorsChatVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "DOTORS_CHAT_ACTIVITY"

  }
}
