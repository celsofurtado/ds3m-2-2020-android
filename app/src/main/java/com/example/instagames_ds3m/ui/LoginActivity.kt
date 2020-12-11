package com.example.instagames_ds3m.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.instagames_ds3m.R
import com.example.instagames_ds3m.model.User
import com.example.instagames_ds3m.repository.UserRepository
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonLogin: Button

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var textViewError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin = findViewById(R.id.button_entry)
        buttonLogin.setOnClickListener(this)

        editTextEmail = findViewById(R.id.edit_text_email)
        editTextPassword = findViewById(R.id.edit_text_password)

        textViewError = findViewById(R.id.text_view_error)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_entry -> {
                autenticar()
            }
        }
    }

    private fun autenticar() {
        val user = User()
        user.name = "user"
        user.email = editTextEmail.text.toString()
        user.password = editTextPassword.text.toString()

        doAsync {
            val login = UserRepository().login(user, applicationContext)
            uiThread {
                if (login == true) {
                    openApp()
                } else {
                    textViewError.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun openApp() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}