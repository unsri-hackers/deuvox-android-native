package com.deuvox.deuvoxapp.feature.register

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set
import androidx.core.text.toSpannable
import com.deuvox.deuvoxapp.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var redirectLogin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        redirectLogin = findViewById(R.id.redirect_login)
        redirectLogin = SpannableClick(
            redirectLogin.text.length-9,
            redirectLogin.text.length,
            redirectLogin
        )
    }

    private fun SpannableClick(start: Int, end: Int, textView: TextView): TextView {
        val redirectText = textView.text.toSpannable()
        redirectText[start until end] = object: ClickableSpan(){
            override fun onClick(View: View) {
                TODO("redirect ke login")
            }
        }
        textView.movementMethod = LinkMovementMethod()
        textView.text = redirectText
        return textView
    }
}