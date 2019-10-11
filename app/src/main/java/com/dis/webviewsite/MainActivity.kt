package com.dis.webviewsite

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {


    lateinit var webView: WebView
    val urlSite = "https://eurotech.by/"
    val urlPhone = ""
    // val urlSite = "https://21vek.by/"
    // val urlSite = "https://onliner.by/"
    // val urlSite = "https://solosecurity.by/"
//    val urlSite = "https://tut.by/"
    val PERMISSION_REQUEST_CODE = 0
    var v = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)



//         //MyWebViewClient(this)
//        webView.webViewClient = object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                if (url.startsWith("http:") || url.startsWith("https:")) {
//                    return false
//                }
//
//                // Otherwise allow the OS to handle things like tel, mailto, etc.
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                startActivity(intent)
//          //      makeCall()
//                return true
//            }
//        }
        webView.webViewClient = MyWebViewClient(this)
        webView.webChromeClient = WebChromeClient()
//        webView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView.requestFocus(View.FOCUS_DOWN)
        webView.isFocusableInTouchMode = true
        //webView.focusable = true Api 26
        webView.settings.domStorageEnabled = true
       // webView.settings.databaseEnabled = true
//        webView.settings.setAppCacheEnabled(true)
//        webView.scrollBarSize = View.SCROLLBARS_INSIDE_OVERLAY

        webView.settings.javaScriptEnabled = true
       // webView.settings.useWideViewPort = false
        //webView.settings.loadWithOverviewMode = true
//        webView.setInitialScale(1)
       // webView.addJavascriptInterface(JavaScriptInterface(this), "AndroidFunction")
        webView.loadUrl(urlSite)

        // webView.loadUrl("javascript:    ('btn btn-primary _phone')[0].click()");




//            webView.evaluateJavascript(
////                "(function() { return ('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>'); })();"
//                "(function() { return ('<html>'+document.getElementsByClassName('_phone-title')[0].innerHTML+'</html>'); })();"
//                //     "(function() { return ('<html>'+document.querySelectorAll(\"a[href='']\")[0].innerHTML+'</html>'); })();"
//
//            ) { html ->
//                //  Log.d("HTML", html)
//
//
//                v = html.substring(12, 31).replace(" ", "")
//                Log.d("HTML", v)
//                makeCall(v)
//
//
//            }


    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makeCall()
                Log.d("HTML", "RequestCode= $PERMISSION_REQUEST_CODE")
            }
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) webView.goBack() else super.onBackPressed()
    }

    fun makeCall() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestForCallPermission()

        } else {

            val intent = Intent(Intent.ACTION_CALL)
            intent.data = (Uri.parse("tel:$v"))
            startActivity(intent)
        }
    }

    private fun requestForCallPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CALL_PHONE
            )
        ) {
            Log.d("HTML", "Yes permission $PERMISSION_REQUEST_CODE")
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                PERMISSION_REQUEST_CODE
            )
            Log.d("HTML", "RequestPermi $PERMISSION_REQUEST_CODE")
        }
    }
}

