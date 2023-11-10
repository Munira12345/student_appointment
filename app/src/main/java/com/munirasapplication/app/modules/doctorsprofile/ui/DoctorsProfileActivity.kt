package com.munirasapplication.app.modules.doctorsprofile.ui

import android.view.View
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDoctorsProfileBinding
import com.munirasapplication.app.modules.doctorsprofile.`data`.model.ListunsplashptrhfmRowModel
import com.munirasapplication.app.modules.doctorsprofile.`data`.viewmodel.DoctorsProfileVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class DoctorsProfileActivity :
    BaseActivity<ActivityDoctorsProfileBinding>(R.layout.activity_doctors_profile) {
  private val viewModel: DoctorsProfileVM by viewModels<DoctorsProfileVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listunsplashptrhfmAdapter =
    ListunsplashptrhfmAdapter(viewModel.listunsplashptrhfmList.value?:mutableListOf())
    binding.recyclerListunsplashptrhfm.adapter = listunsplashptrhfmAdapter
    listunsplashptrhfmAdapter.setOnItemClickListener(
    object : ListunsplashptrhfmAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListunsplashptrhfmRowModel) {
        onClickRecyclerListunsplashptrhfm(view, position, item)
      }
    }
    )
    viewModel.listunsplashptrhfmList.observe(this) {
      listunsplashptrhfmAdapter.updateData(it)
    }
    binding.doctorsProfileVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListunsplashptrhfm(
    view: View,
    position: Int,
    item: ListunsplashptrhfmRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "DOCTORS_PROFILE_ACTIVITY"

  }
}
