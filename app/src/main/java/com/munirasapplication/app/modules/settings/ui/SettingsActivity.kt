  package com.munirasapplication.app.modules.settings.ui

  import android.content.Context
  import android.content.Intent
  import android.os.Bundle
  import android.widget.ImageView
  import androidx.appcompat.app.AppCompatActivity
    import com.munirasapplication.app.R
  import com.munirasapplication.app.modules.dashboard.ui.DashboardActivity

  class SettingsActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_settings)


          val imageHome: ImageView = findViewById(R.id.imageHome)

          imageHome.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
          }

     }
  companion object {
    const val TAG: String = "SETTINGS_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SettingsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
