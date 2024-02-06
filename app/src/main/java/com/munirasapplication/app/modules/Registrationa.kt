package com.munirasapplication.app.modules

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.munirasapplication.app.R

class Registrationa : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrationa)

        firebaseAuth = FirebaseAuth.getInstance()

        val emailLayout: TextInputLayout = findViewById(R.id.emailLayout)
        val passwordLayout: TextInputLayout = findViewById(R.id.passwordLayout)
        val registerButton: Button = findViewById(R.id.registerButton)
        val loginButton: Button = findViewById(R.id.loginButton)



        loginButton.setOnClickListener {
            val intent = Intent(this, LoginA::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val emailEditText: TextInputEditText = emailLayout.findViewById(R.id.emailEditText)
            val passwordEditText: TextInputEditText = passwordLayout.findViewById(R.id.passwordEditText)

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Registration successful, navigate to Dashboard
                            val intent = Intent(this, LoginA::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val errorMessage = task.exception?.message
                            Toast.makeText(this, "Registration not successful: $errorMessage", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }


    }
}
