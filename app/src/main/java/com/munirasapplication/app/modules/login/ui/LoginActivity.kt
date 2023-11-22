package com.munirasapplication.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityLoginBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.registration.ui.RegistrationActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

  override lateinit var binding: ActivityLoginBinding
  private lateinit var firebaseAuth: FirebaseAuth

  override fun onInitialized() {
    // Initializing the binding
    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)

    // Initializing Firebase Authentication
    firebaseAuth = FirebaseAuth.getInstance()
  }

  override fun setUpClicks() {
    // Click listener for navigating to the registration activity
    binding.txtConfirmation.setOnClickListener {
      navigateToRegistration()
    }

    // Click listener for the login button
    binding.btnRegisterOne.setOnClickListener {
      attemptLogin()
    }
  }

  private fun navigateToRegistration() {
    val intent = Intent(this, RegistrationActivity::class.java)
    startActivity(intent)
  }

  private fun attemptLogin() {
    val email = binding.btnEnterYourEmailOne.text.toString().trim()
    val password = binding.passET.text.toString().trim()

    if (email.isNotEmpty() && password.isNotEmpty()) {
      signInWithEmailAndPassword(email, password)
    } else {
      showToast("Empty Fields Are not Allowed !!")
    }
  }

  private fun signInWithEmailAndPassword(email: String, password: String) {
    firebaseAuth.signInWithEmailAndPassword(email, password)
      .addOnCompleteListener { task ->
        if (task.isSuccessful) {
          navigateToDashboard()
        } else {
          showToast("Login failed: ${task.exception?.message}")
        }
      }
  }

  private fun navigateToDashboard() {
    val intent = Intent(this, DashboardActivity::class.java)
    startActivity(intent)
  }

  private fun showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }

  companion object {
    const val TAG: String = "LOGIN_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      return Intent(context, LoginActivity::class.java).apply {
        putExtra("bundle", bundle)
      }
    }
  }
}

