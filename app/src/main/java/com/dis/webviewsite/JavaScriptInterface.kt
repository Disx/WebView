package com.dis.webviewsite

import android.content.Context
import android.widget.Toast
import android.webkit.JavascriptInterface


class JavaScriptInterface internal constructor(internal var mContext: Context) {

    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}