package com.munirasapplication.app.modules

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


    /*added code for moving registered user to dashboard
   override fun onStart() {
    super.onStart()

    // Check if the user is already logged in
    val currentUser = firebaseAuth.currentUser
    if (currentUser != null) {
        // User is already logged in, navigate to DashboardActivity
        navigateToDashboard()
    }
}

    private fun navigateToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        firebaseAuth = FirebaseAuth.getInstance()

        //creating all the objects

        val emailLayout: TextInputLayout = findViewById(R.id.emailLayout)
        val passwordLayout: TextInputLayout = findViewById(R.id.passwordLayout)
        val loginButton3: Button = findViewById(R.id.loginButton3)
        val txtConfirmation = findViewById<TextView>(R.id.txtConfirmation)

        txtConfirmation.setOnClickListener {
            val intent = Intent(this, Registrationa::class.java)
            startActivity(intent)
        }


        loginButton3.setOnClickListener {
            val emailEditText: TextInputEditText = emailLayout.findViewById(R.id.btnEnterYourEmailOne)
            val passwordEditText: TextInputEditText = passwordLayout.findViewById(R.id.passET)

            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // authentication successful, navigate to Dashboard
                            val intent = Intent(this, DashboardActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val errorMessage = task.exception?.message
                            Toast.makeText(this, "Login not successful: $errorMessage", Toast.LENGTH_SHORT).show()
                        }
                    }
            }





           /* } else {
                showToast("Empty Fields Are not Allowed !!")
            }
        }


    }

      /*private fun signInWithEmailAndPassword(email: String, password: String) {
    firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navigateToDashboard()
                } else {
                    val errorMessage = task.exception?.message
                   showToast("Login Failed: $errorMessage")
                }

            }



        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
        showToast("Login Successful")
}
*/


    private fun signInWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Authentication successful, navigate to DashboardActivity
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                    showToast("Login Successful")
                } else {
                    val errorMessage = task.exception?.message
                    showToast("Login Failed: $errorMessage")
                }
            }
    }
/*
    private fun navigateToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

*/

    private fun navigateToRegistration() {

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    */
        /*
         <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/btnLogin"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:layout_marginStart="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/passwordLayout"
        android:text="Login"
        style="@style/btnSolid" />
         */

        }}
}
