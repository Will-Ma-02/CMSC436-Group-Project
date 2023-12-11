package com.example.groupproject

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class CustomToast {

    companion object {
        fun makeText(context: Context, message: CharSequence?, duration: Int) {
            val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                toast.show()
            }, 0)
            handler.postDelayed({
                toast.cancel()
            }, duration.toLong())
        }
    }
}