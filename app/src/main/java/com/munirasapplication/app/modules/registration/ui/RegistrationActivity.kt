package com.munirasapplication.app.modules.registration.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActivityRegistrationBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.login.ui.LoginActivity
import com.munirasapplication.app.modules.registration.`data`.viewmodel.RegistrationVM
import kotlin.String
import kotlin.Unit
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import androidx.appcompat.widget.AppCompatButton

class RegistrationActivity :
    BaseActivity<ActivityRegistrationBinding>(R.layout.activity_registration) {
  private val viewModel: RegistrationVM by viewModels<RegistrationVM>()


// creating latent var for binding

  override lateinit var binding: ActivityRegistrationBinding
  private lateinit var firebaseAuth: FirebaseAuth


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registrationVM = viewModel

    //added
    // we initialize the binding activity
    binding = ActivityRegistrationBinding.inflate(layoutInflater)
    setContentView(binding.root)

// for firebase
    firebaseAuth = FirebaseAuth.getInstance()
  }

  override fun setUpClicks(): Unit {

    // added code
    /*val btnRegisterOne = binding.root.findViewById<Button>(R.id.btnRegisterOne)
    btnRegisterOne.setOnClickListener{
      // handle the button click and navigate to dashboard activity
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }
     */

    val txtConfirmation = binding.root.findViewById<TextView>(R.id.txtConfirmation)
    txtConfirmation.setOnClickListener {
      // handle the text view click and navigate to login activity
      val intent = Intent(this, LoginActivity::class.java)
      startActivity(intent)
    }

    //code

    //adding a textview so if the user is already registered

    binding.txtConfirmation.setOnClickListener{
      val intent = Intent(this, LoginActivity::class.java)
      startActivity(intent)
    }

    binding.btnRegisterOne.setOnClickListener {
      val email = binding.btnEnterYourEmailOne.text.toString()
      val pass = binding.passET.text.toString()
      val confirmPass = binding.confirmPassEt.text.toString()

      if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
        if (pass == confirmPass) {

          firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful) {
              val intent = Intent(this, LoginActivity::class.java)
              startActivity(intent)
            } else {
              Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

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

  companion object {
    const val TAG: String = "REGISTRATION_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegistrationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }


  }
  }
