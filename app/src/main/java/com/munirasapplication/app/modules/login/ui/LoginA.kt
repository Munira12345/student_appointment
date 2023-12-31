package com.munirasapplication.app.modules.login.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.munirasapplication.app.R
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity

class LoginA : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        firebaseAuth = FirebaseAuth.getInstance()

        val emailLayout: TextInputLayout = findViewById(R.id.emailLayout)
        val passwordLayout: TextInputLayout = findViewById(R.id.passwordLayout)
        val loginButton: Button = findViewById(R.id.btnLogin)
        val txtConfirmation = findViewById<TextView>(R.id.txtConfirmation)

        loginButton.setOnClickListener {
            val emailEditText: TextInputEditText = emailLayout.findViewById(R.id.btnEnterYourEmailOne)
            val passwordEditText: TextInputEditText = passwordLayout.findViewById(R.id.passET)

            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                signInWithEmailAndPassword(email, password)
            } else {
                showToast("Empty Fields Are not Allowed !!")
            }
        }

        txtConfirmation.setOnClickListener {
            navigateToRegistration()
        }
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
//        firebaseAuth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    navigateToDashboard()
//                } else {
//                    val errorMessage = task.exception?.message
//                    showToast("Login Failed: $errorMessage")
//                }
//            }
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
        showToast("Login Successful")
    }

    private fun navigateToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToRegistration() {

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
