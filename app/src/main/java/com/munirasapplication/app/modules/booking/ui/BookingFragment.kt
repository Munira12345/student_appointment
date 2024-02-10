package com.munirasapplication.app.modules.booking.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.munirasapplication.app.R
import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity

class BookingFragment : AppCompatActivity() {

  private lateinit var database: FirebaseDatabase
  private lateinit var auth: FirebaseAuth


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_booking)

    database = FirebaseDatabase.getInstance()
    auth = FirebaseAuth.getInstance()


    //creating all the objects

    val button: Button = findViewById(R.id.button)
    val button4: Button = findViewById(R.id.button4)
    val button5: Button = findViewById(R.id.button5)
    val button7: Button = findViewById(R.id.button7)
    val button8: Button = findViewById(R.id.button8)
    val imagePlus: ImageView = findViewById(R.id.imagePlus)

    /*

    val timeButtons = listOf(button, button4, button5, button7, button8)

    for (button in timeButtons) {
      button.setOnClickListener {
        val time = button.text.toString()
        val currentUser = auth.currentUser
        val userEmail = currentUser?.email

        if (userEmail != null) {
          saveAppointmentToDatabase(time, userEmail)
        }
      }
    }

    imagePlus.setOnClickListener {
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }
  }

  private fun saveAppointmentToDatabase(time: String, email: String) {
    val appointmentRef = database.getReference("appointments")
    val appointmentId = appointmentRef.push().key ?: return

    val appointmentData = hashMapOf(
      "time" to time,
      "email" to email
    )

    appointmentRef.child(appointmentId).setValue(appointmentData)
      .addOnSuccessListener {
        // Data saved successfully
      }
      .addOnFailureListener { e ->
        // Error occurred while saving data
      }
  }
*/



    button.setOnClickListener {
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }
    imagePlus.setOnClickListener {
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }

    button4.setOnClickListener {
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }

    button5.setOnClickListener {
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }

    button7.setOnClickListener {
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }

    button8.setOnClickListener {
      val intent = Intent(this, DashboardActivity::class.java)
      startActivity(intent)
    }

  }


      companion object {
        const val TAG: String = "BOOKING_FRAGMENT"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
         val destIntent = Intent(context, BookingFragment::class.java)
         destIntent.putExtra("bundle", bundle)
         return destIntent
          }

      }
}
