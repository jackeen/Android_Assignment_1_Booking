package app.fatal.assignment_1_booking

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.fatal.assignment_1_booking.user.UserState
import com.google.android.material.textfield.TextInputEditText

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var toolbar: Toolbar = findViewById<Toolbar>(R.id.profile_toolbar)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })

        val userState = UserState(this)
        val user = userState.getCurrentUser()
        if (user != null) {
            findViewById<ImageView>(R.id.profile_image).setImageResource(user.avatar)
            findViewById<TextView>(R.id.profile_user_name).text = "User Name: ${user.userName}"
            findViewById<TextView>(R.id.profile_role).text = "${user.role.name}"
            findViewById<TextInputEditText>(R.id.profile_first_name).setText(user.firstName)
            findViewById<TextInputEditText>(R.id.profile_last_name).setText(user.lastName)
            findViewById<TextInputEditText>(R.id.profile_phone).setText(user.phone)
            findViewById<TextInputEditText>(R.id.profile_email).setText(user.email)
        }

    }
}