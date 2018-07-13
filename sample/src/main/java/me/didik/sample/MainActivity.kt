package me.didik.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.didik.ioswidget.dialog.IOSDialog
import me.didik.ioswidget.loading.IOSLoading

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iosDialog = IOSDialog(this)
        iosDialog.apply {
            setTitle(getString(R.string.example_title))
            setSubtitle(getString(R.string.example_subtitle))
            setBoldPositiveLabel(true)
            setPositiveLabel("OK")
            setNegativeLabel("Dismiss")
            setPositiveListener {
                Toast.makeText(this@MainActivity, "Positive Clicked", Toast.LENGTH_SHORT).show()
            }
            setNegativeListener { it.dismiss() }
        }

        btnDialog.setOnClickListener { iosDialog.show() }

        val iosLoading = IOSLoading(this, "Download")
        var count = 0
        btnLoading.setOnClickListener {
            iosLoading.setTitle("Loading $count")
            iosLoading.show()
            count++
        }
    }
}
