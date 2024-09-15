package app.fatal.assignment_1_booking

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.fatal.assignment_1_booking.user.UserState

class UserStateActivity : AppCompatActivity() {

    private lateinit var btnLogin : Button
    private lateinit var btnLogout : Button
    private lateinit var btnRegister : Button
    private lateinit var btnProfile : Button
    private lateinit var btnDeals : Button

    private lateinit var imageView : ImageView
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_state)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // toolbar setting
        val toolbar = findViewById<Toolbar>(R.id.user_state_tool_bar)
        toolbar.title = "User State"
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })

        btnLogin = findViewById<Button>(R.id.user_state_login_btn)
        btnLogout = findViewById<Button>(R.id.user_state_logout_btn)
        btnRegister = findViewById<Button>(R.id.user_state_register_btn)
        btnProfile = findViewById<Button>(R.id.user_state_profile_btn)
        btnDeals = findViewById<Button>(R.id.user_state_deals_btn)
        imageView = findViewById<ImageView>(R.id.user_state_image)
        textView = findViewById<TextView>(R.id.user_state_name)


        btnLogin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })
        btnLogout.setOnClickListener(View.OnClickListener {
            val userState = UserState(this)
            userState.logout()
            refreshUI()
        })
        btnRegister.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        })
        btnProfile.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        })
        btnDeals.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, DealsActivity::class.java)
            startActivity(intent)
        })

        refreshUI()
    }

    override fun onResume() {
        super.onResume()
        refreshUI()
    }

    private fun refreshUI() {
        val userState = UserState(this)
        val currentUser = userState.getCurrentUser()
        if (currentUser == null) {
            textView.text = "Visitor"
            imageView.setImageResource(R.drawable.visitor)
            btnLogin.visibility = View.VISIBLE
            btnRegister.visibility = View.VISIBLE
            btnLogout.visibility = View.GONE
            btnProfile.isEnabled = false
            btnDeals.isEnabled = false
        } else {
            imageView.setImageResource(currentUser.avatar)
            textView.text = "${currentUser.firstName} ${currentUser.lastName}"
            btnLogout.visibility = View.VISIBLE
            btnLogin.visibility = View.GONE
            btnRegister.visibility = View.GONE
            btnProfile.isEnabled = true
            btnDeals.isEnabled = true
        }
    }


}