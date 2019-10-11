package com.dis.webviewsite

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.webkit.WebView
import android.webkit.WebViewClient


class MyWebViewClient(val context: Context) : WebViewClient() {

    @TargetApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        if (url!!.startsWith("http:") || url!!.startsWith("https:")) {
            return false
        }

        // Otherwise allow the OS to handle things like tel, mailto, etc.
//    val ma = MainActivity()
//    ma.makeCall()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
        return true

    }

//    override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
//        // TODO Auto-generated method stub
//        super.onPageStarted(view, url, favicon)
    // Toast.makeText(TableContentsWithDisplay.this, "url "+url, Toast.LENGTH_SHORT).show();
//
//    }


//    override fun onLoadResource(view: WebView?, url: String?) {
//       // super.onLoadResource(view, url)
//        view!!.loadUrl("javascript:(function(){var m=document.createElement('META'); m.name='viewport'; m.content='width=device-width, user-scalable=yes'; document.body.appendChild(m);})()")
//    }

    override fun onPageFinished(view: WebView?, url: String?) {
        // super.onPageFinished(view, url)
        // view!!.loadUrl("javascript:(function(){var m=document.createElement('META'); m.name='viewport'; m.content='width=device-width, user-scalable=yes'; document.body.appendChild(m);})()")
        // view!!.loadUrl("javascript:document.getElementsByClassName('btn btn-primary _phone')[0].click()");
        // Toast.makeText(TableContentsWithDisplay.this, "Width " + view.getWidth() +" *** " + "Height " + view.getHeight(), Toast.LENGTH_SHORT).show();
//        view!!.evaluateJavascript(
////                "(function() { return ('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>'); })();"
//       //     "(function() { return ('<html>'+document.getElementsByClassName('btn btn-primary _phone')[0].innerHTML+'</html>'); })();"
//           //     "(function() { return ('<html>'+document.querySelectorAll(\"a[href='']\")[0].innerHTML+'</html>'); })();"
//
//        ) { html -> Log.d("HTML", html)}
        //  view!!.loadUrl("javascript: document.getElementsByClassName('_phone-title').onclick= function(){AndroidFunction.showToast('Привет');}")
    }
}



