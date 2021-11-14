package com.example.deuvox.feature.register

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set
import androidx.core.text.toSpannable
import com.example.deuvox.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var redirectLogin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        redirectLogin = findViewById(R.id.redirect_login)
        val redirectText = redirectLogin.text.toSpannable()
        redirectText[redirectText.length-9 until redirectText.length] = object: ClickableSpan(){
            override fun onClick(View: View) {
                TODO("Not implemented yet")
            }
        }
        redirectLogin.movementMethod = LinkMovementMethod()
        redirectLogin.text = redirectText
    }
}