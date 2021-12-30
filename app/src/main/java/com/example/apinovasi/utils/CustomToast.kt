package com.example.apinovasi.utils

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.example.apinovasi.R

fun Toast.showCustomToast(message: String, activity: Activity) {
    val layout = activity.layoutInflater.inflate(
        R.layout.custom_toast,
        activity.findViewById(R.id.toast_container)
    )

    val textView = layout.findViewById<TextView>(R.id.tv_message)
    textView.text = message

    this.apply {
        setGravity(Gravity.BOTTOM, 0, 60)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}