package app.fatal.assignment_1_booking

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.fatal.assignment_1_booking.user.UserState
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    lateinit var userNameView: TextInputEditText
    lateinit var userPasswordView: TextInputEditText

    lateinit var btnLogin: Button
    lateinit var btnGoRegist: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toobar = findViewById<Toolbar>(R.id.login_toolbar)
        toobar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })

        userNameView = findViewById(R.id.login_username_editor)
        userPasswordView = findViewById(R.id.login_password_editor)

        btnLogin = findViewById(R.id.login_login_btn)
        btnGoRegist = findViewById(R.id.login_go_register_btn)

        btnLogin.setOnClickListener(View.OnClickListener {
            val userState = UserState(this)
            val userName = userNameView.text.toString().trim()
            val password = userPasswordView.text.toString().trim()

            if (userName == "" || password == "") {
                Toast.makeText(this, "User name and password should input", Toast.LENGTH_SHORT).show()
            } else {
                val user = userState.login(userName, password)
                if (user != null) {
                    Toast.makeText(this, "${user.userName} is login.", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "The UserName or Password is incorrect.", Toast.LENGTH_SHORT).show()
                }
            }
        })

        btnGoRegist.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        })
    }
}
