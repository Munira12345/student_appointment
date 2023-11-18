package com.munirasapplication.app.modules.login.ui

import android.content.Intent
import androidx.activity.viewModels
import com.munirasapplication.app.R
import com.munirasapplication.app.appcomponents.base.BaseActivity
import com.munirasapplication.app.databinding.ActicityLoginBinging
import com.munirasapplication.app.modules.login.`data`.viewmodel.LoginVM
import androidx.activity.viewModels
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.munirasapplication.app.databinding.ActivityLoginBinding
import com.munirasapplication.app.databinding.ActivityRegistrationBinding
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity
import com.munirasapplication.app.modules.registration.ui.RegistrationActivity
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
  private val viewModel: LoginVM by viewModels<LoginVM>()


  private lateinit var binding: ActivityLoginBinding
  private lateinit var firebaseAuth: FirebaseAuth

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel


    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)

    firebaseAuth = FirebaseAuth.getInstance()

    binding.txtConfirmation.setOnClickListener{ it:View!
      val intent = Intent(this, RegistrationActivity::class.java)
      startActivity(intent)
    }


    binding.txtConfirmation.setOnClickListener{ it:View!
      val email = binding.btnEnterYourEmailOne.text.toString()
      val pass = binding.passET.text.toString()

      if (email.isNotEmpty() && pass.isNotEmpty()) {

        firebaseAuth.logInWithEmailAndPassword(email, pass).addOnCompleteListener {
          if (it.isSuccessful) {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
          } else {
            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

          }
        }
        else {
          Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
        }
      }
    }
  }

  override fun setUpClicks(): Unit {

    //
    // added code
  /*  val btnRegisterOne = binding.root.findViewById<Button>(R.id.btnRegisterOne)
    btnRegisterOne.setOnClickListener {
      // handle the button click and navigate to dashboard activity
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }
    */



  }
  /*companion object
    {
    const val TAG: String = "LOGIN_ACTIVITY"
*/
      companion object {
        const val TAG: String = "LOGIN_ACTIVITY"

    }
  }
