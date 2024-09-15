package app.fatal.assignment_1_booking

import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.fatal.assignment_1_booking.model.Role
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // toolbar setting
        val toolbar = findViewById<Toolbar>(R.id.register_toolbar)
        toolbar.setNavigationOnClickListener(View.OnClickListener {
            finish()
        })

        val completeTextView = findViewById<MaterialAutoCompleteTextView>(R.id.register_user_type_complete_text)
        val userTypes = arrayOf(Role.CUSTOMER.name, Role.SUPPLIER.name)
        completeTextView.setSimpleItems(userTypes)
        //completeTextView.text.toString()

        findViewById<Button>(R.id.register_register_btn).setOnClickListener(View.OnClickListener {

        })

    }
}