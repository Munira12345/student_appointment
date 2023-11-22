package com.munirasapplication.app.modules.registration.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityRegistrationBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.login.ui.LoginActivity
import com.munirasapplication.app.modules.registration.data.viewmodel.RegistrationVM

class RegistrationActivity : BaseActivity<ActivityRegistrationBinding>(R.layout.activity_registration) {
  private val viewModel: RegistrationVM by viewModels()

   override lateinit var binding: ActivityRegistrationBinding
  private lateinit var firebaseAuth: FirebaseAuth

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")

    // Initialize the binding activity
    binding = ActivityRegistrationBinding.inflate(layoutInflater)
    setContentView(binding.root)

    // Set the view model
    binding.registrationVM = viewModel

    // For Firebase
    firebaseAuth = FirebaseAuth.getInstance()
  }

  override fun setUpClicks() {


  binding.txtConfirmation.setOnClickListener {
      val intent = Intent(this, LoginActivity::class.java)
      startActivity(intent)
    }


    binding.btnRegisterOne.setOnClickListener {
      val email = binding.btnEnterYourEmailOne.text.toString()
      val pass = binding.passET.text.toString()
      val confirmPass = binding.confirmPassEt.text.toString()

      if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
        if (pass == confirmPass) {
          firebaseAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
              if (task.isSuccessful) {
                // Registration successful, navigate to Dashboard
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish() // Finish this activity to prevent going back to registration
              } else {
                // Registration failed, show an error message
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
              }
            }
        } else {
          Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
        }
      } else {
        Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
      }
    }
  }

 val btnRegisterOne = binding.root.findViewById<btnRegisterOne>(R.id.btnRegisterOne)
  btnRegisterOne.setOnClickListener {
    // Handle the button click and navigate to DashboardActivity
    val intent = Intent(this, DashboardActivity::class.java)
    startActivity(intent)
  }

  val txtConfirmation = binding.root.findViewById<TextView>(R.id.txtConfirmation)
  txtConfirmation.setOnClickListener {
    // Handle the TextView click and navigate to LoginActivity
    val intent = Intent(this, LoginActivity::class.java)
    startActivity(intent)
  }
}


  companion object {
    const val TAG: String = "REGISTRATION_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegistrationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
