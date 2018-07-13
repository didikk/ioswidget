package me.didik.ioswidget.loading

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import me.didik.ioswidget.R

class IOSLoading(context: Context, message: String) : Dialog(context) {
    private var title: TextView? = null
    private var spinner: CamomileSpinner? = null

    init {
        setContentView(R.layout.ios_progress_dialog)

        if (window != null)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        title = findViewById(R.id.message)
        spinner = findViewById(R.id.spinner)

        title?.text = message

        spinner?.recreateWithParams(context, CamomileSpinner.DEFAULT_COLOR,
                CamomileSpinner.DEFAULT_DURATION, true)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        val spinnerAnimation = spinner?.background as AnimationDrawable
        spinnerAnimation.start()
    }

}