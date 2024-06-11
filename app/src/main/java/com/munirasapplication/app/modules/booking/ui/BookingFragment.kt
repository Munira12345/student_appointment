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
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.munirasapplication.app.modules.booking.ui.BookingFragment

class BookingFragment : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.fragment_booking)


       //creating all the objects well

       val button12: Button = findViewById(R.id.button12)
       val button4: Button = findViewById(R.id.button4)
       val button5: Button = findViewById(R.id.button5)
       val button7: Button = findViewById(R.id.button7)
       val button8: Button = findViewById(R.id.button8)
       val imagePlus: ImageView = findViewById(R.id.imagePlus)


       button12.setOnClickListener {
           val time = "8:00 AM"
           saveAppointmentToDatabase(time)
           val intent = Intent(this, DashboardActivity::class.java)
           startActivity(intent)
       }

       imagePlus.setOnClickListener {
           val intent = Intent(this, DashboardActivity::class.java)
           startActivity(intent)
       }

       button4.setOnClickListener {
           val time = "10:00 AM" // Change the time as needed
           saveAppointmentToDatabase(time)
           val intent = Intent(this, DashboardActivity::class.java)
           startActivity(intent)
       }

       button5.setOnClickListener {
           val time = "12:00 " // Change the time as needed
           saveAppointmentToDatabase(time)
           val intent = Intent(this, DashboardActivity::class.java)
           startActivity(intent)
       }

       button7.setOnClickListener {
           val time = "1:00 PM" // Change the time as needed
           saveAppointmentToDatabase(time)
           val intent = Intent(this, DashboardActivity::class.java)
           startActivity(intent)
       }

       button8.setOnClickListener {
           val time = "2:00 PM" // Change the time as needed
           saveAppointmentToDatabase(time)
           val intent = Intent(this, DashboardActivity::class.java)
           startActivity(intent)
       }
   }

       private fun bookAppointmentAndNavigate(time: String) {
           saveAppointmentToDatabase(time)
           navigateToDashboard()
       }

      private fun saveAppointmentToDatabase(time: String) {
           val currentUserEmail = FirebaseAuth.getInstance().currentUser?.email
           val appointmentRef = FirebaseDatabase.getInstance().getReference("appointments")
           val appointmentId = appointmentRef.push().key ?: return

           val appointmentData = hashMapOf(
               "time" to time,
               "email" to currentUserEmail
           )

           appointmentRef.child(appointmentId).setValue(appointmentData)
               .addOnSuccessListener {
                   // Data saved successfully
               }
               .addOnFailureListener { e ->
                   // Error occurred while saving data
               }
       }

       private fun navigateToDashboard() {
           val intent = Intent(this, DashboardActivity::class.java)
           startActivity(intent)
       }

    /*   imagePlus.setOnClickListener {
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

*/


      companion object {
        const val TAG: String = "BOOKING_FRAGMENT"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
         val destIntent = Intent(context, BookingFragment::class.java)
         destIntent.putExtra("bundle", bundle)
         return destIntent
          }

      }
}
