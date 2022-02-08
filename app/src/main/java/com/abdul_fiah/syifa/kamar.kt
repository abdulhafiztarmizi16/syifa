package com.abdul_fiah.syifa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_kamar.*

class kamar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kamar)

        webViewSetup()
    }
    private fun webViewSetup(){
        web_webView.webViewClient = WebViewClient()

        web_webView.apply{
            loadUrl("https://abdulwebdev.000webhostapp.com/")
            settings.javaScriptEnabled = true

        }
    }
}