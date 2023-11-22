package com.munirasapplication.app.modules.registration.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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


    binding = ActivityRegistrationBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.registrationVM = viewModel

    firebaseAuth = FirebaseAuth.getInstance()
  }

  override fun setUpClicks() {
//
//
//  binding.txtConfirmation.setOnClickListener {
//      val intent = Intent(this, LoginActivity::class.java)
//      startActivity(intent)
//    }
//
//    binding.btnRegisterOne.setOnClickListener {
//      val email = findViewById<EditText>(R.id.btnEnterYourEmailOne).text.toString()
//      val password = findViewById<EditText>(R.id.passET).text.toString()
//      val confirmPassword = findViewById<EditText>(R.id.confirmPassEt).text.toString()
//
//
//      if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
//        if (password == confirmPassword) {
//          firebaseAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//              if (task.isSuccessful) {
//                // Registration successful, navigate to Dashboard
//                val intent = Intent(this, DashboardActivity::class.java)
//                startActivity(intent)
//                finish() // Finish this activity to prevent going back to registration
//              } else {
//                // Registration failed, show an error message
//                Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
//              }
//            }
//        } else {
//          Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
//        }
//      } else {
//        Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
//      }
//    }
//  }



 val btnRegisterOne = binding.root.findViewById<Button>(R.id.btnRegisterOne)
  btnRegisterOne.setOnClickListener {
    val intent = Intent(this, DashboardActivity::class.java)
    startActivity(intent)
  }

  val txtConfirmation = binding.root.findViewById<TextView>(R.id.txtConfirmation)
  txtConfirmation.setOnClickListener {

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
