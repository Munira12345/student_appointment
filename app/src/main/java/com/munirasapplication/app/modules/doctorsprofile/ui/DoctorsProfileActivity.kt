package com.munirasapplication.app.modules.doctorsprofile.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityDoctorsProfileBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.doctorsprofile.`data`.model.ListunsplashptrhfmRowModel
import com.munirasapplication.app.modules.doctorsprofile.`data`.viewmodel.DoctorsProfileVM
import com.munirasapplication.app.modules.patientrequests.ui.PatientRequestsActivity
import com.munirasapplication.app.modules.registration.ui.RegistrationActivity
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

    //clicks
    val button2 = binding.root.findViewById<Button>(R.id.button2)
    button2.setOnClickListener{
      // handle the button click and navigate to the patients requests activity
      val intent = Intent(this, PatientRequestsActivity::class.java)
      startActivity(intent)
    }

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


    //added code
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegistrationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
