package com.xthan.prophuntrun

import android.webkit.WebChromeClient
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var webV: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        webV = findViewById(R.id.myWebView)
        webV.settings.javaScriptEnabled = true
        webV.webChromeClient = WebChromeClient()

        if (savedInstanceState != null) {
            webV.restoreState(savedInstanceState)
        } else {
            webV.loadUrl("file:///android_asset/index.html")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webV.saveState(outState)
    }
}
