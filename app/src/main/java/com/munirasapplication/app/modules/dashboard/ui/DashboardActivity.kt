package com.munirasapplication.app.modules.dashboard.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.munirasapplication.app.R
import com.munirasapplication.app.modules.booking.ui.BookingFragment
import com.munirasapplication.app.modules.settings.ui.SettingsActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val button2: Button = findViewById(R.id.button2)
        val imageUser: ImageView = findViewById(R.id.imageUser)

        button2.setOnClickListener {
            val intent = Intent(this, BookingFragment::class.java)
            startActivity(intent)
        }

        imageUser.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val TAG: String = "DASHBOARD_ACTIVITY"

        fun getIntent(context: Context, bundle: Bundle?): Intent {
            val destIntent = Intent(context, DashboardActivity::class.java)
            destIntent.putExtra("bundle", bundle)
            return destIntent
        }
    }
}

/*
      val appointmentRef = database.getReference("appointments")
      val currentUser = auth.currentUser
      val userEmail = currentUser?.email



      appointmentRef.orderByChild("email").equalTo(userEmail).addValueEventListener(object :
        ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
          val appointments = mutableListOf<String>()
          for (appointmentSnapshot in snapshot.children) {
            val time = appointmentSnapshot.child("time").value.toString()
            appointments.add(time)
          }
          appointmentTextView.text = appointments.joinToString("\n")
          viewModel.updateAppointmentDetails(appointmentDetails) // Update ViewModel with appointment details

        }

        override fun onCancelled(error: DatabaseError) {
          // Handle the error as needed
        }


      })


*  <TextView android:ellipsize="end"
                    android:id="@+id/txtGoodmorning"
                    android:layout_gravity="end"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="@dimen/_10pxv"
                    android:layout_marginEnd="@dimen/_120pxh"
                    android:layout_marginStart="@dimen/_86pxh"
                    android:layout_marginTop="@dimen/_20pxv"
                    android:layout_width="wrap_content"
                    android:singleLine="true"
                    android:text="@{dashboardVM.dashboardModel.txtGoodmorningian}"
                    style="@style/txtPoppinssemibold18_1" tools:text="Dashboard"/>
                    *
                    * <TextView android:ellipsize="end"
                android:gravity="center_horizontal"
                android:id="@+id/txtYouhaveoneup"
                android:layout_height="wrap_content"
                android:layout_marginEnd="@dimen/_17pxh"
                android:layout_marginStart="@dimen/_17pxh"
                android:layout_marginTop="@dimen/_35pxv"
                android:layout_width="match_parent"
                android:singleLine="true"
                android:text="@{dashboardVM.dashboardModel.txtYouhaveoneup}"
                style="@style/txtPoppinssemibold12" tools:text="Upcoming meetings"/>
                *
                * <LinearLayout android:gravity="start"
                android:id="@+id/linearDoctordetails"
                android:layout_height="wrap_content"
                android:layout_marginEnd="@dimen/_17pxh"
                android:layout_marginStart="@dimen/_17pxh"
                android:layout_marginTop="@dimen/_21pxv"
                android:layout_width="match_parent"
                android:orientation="horizontal" style="@style/groupStylebluegray_50_a0cornerRadius">
                <ImageView android:id="@+id/imageUnsplashpTrhfm"
                    android:layout_height="@dimen/_70pxh"
                    android:layout_marginBottom="@dimen/_4pxv"
                    android:layout_marginStart="@dimen/_38pxh"
                    android:layout_marginTop="@dimen/_9pxv"
                    android:layout_width="@dimen/_70pxh"
                    android:scaleType="fitXY"
                    cornerRadius="@{@dimen/_20pxh}"
                    imageRes="@{@drawable/img_unsplashptrhfm}"
                    tools:ignore="ContentDescription" tools:src="@drawable/img_unsplashptrhfm"/>
                <LinearLayout
                    android:id="@+id/linearColumnfrancissktelz"
                    android:layout_height="wrap_content"
                    android:layout_marginBottom="@dimen/_16pxv"
                    android:layout_marginStart="@dimen/_23pxh"
                    android:layout_marginTop="@dimen/_24pxv"
                    android:layout_weight="0.63"
                    android:layout_width="0dp" android:orientation="vertical">
                    <TextView android:ellipsize="end"
                        android:gravity="start"
                        android:id="@+id/txtFrancisSktelz"
                        android:layout_height="wrap_content"
                        android:layout_marginEnd="@dimen/_10pxh"
                        android:layout_width="match_parent"
                        android:singleLine="true"
                        android:text="@{dashboardVM.dashboardModel.txtFrancisSktelz}"
                        style="@style/txtPoppinssemibold12_1" tools:text="@string/lbl_francis_sktelz"/>
                    <TextView android:ellipsize="end"
                        android:id="@+id/txtTimeOne"
                        android:layout_gravity="start"
                        android:layout_height="wrap_content"
                        android:layout_marginEnd="@dimen/_14pxh"
                        android:layout_marginStart="@dimen/_14pxh"
                        android:layout_marginTop="@dimen/_7pxv"
                        android:layout_width="wrap_content"
                        android:singleLine="true"
                        android:text="@{dashboardVM.dashboardModel.txtTimeOne}"
                        style="@style/txtPoppinssemibold11" tools:text="@string/lbl_12_10pm"/>
                    <TextView
                        android:id="@+id/txtAppointmentDetails"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_marginTop="@dimen/_7pxv"
                        android:layout_marginStart="@dimen/_14pxh"
                        android:layout_marginEnd="@dimen/_14pxh"
                        android:gravity="start"
                        android:singleLine="true"
                        android:text="@{dashboardVM.dashboardModel.appointmentDetails}"
                        style="@style/txtPoppinssemibold11"
                        tools:text="Appointment Details: " />
                </LinearLayout>
                    *
                    *
* */