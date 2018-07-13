package me.didik.ioswidget.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.TextView
import me.didik.ioswidget.R
import me.didik.ioswidget.gone

class IOSDialog(context: Context) {
    private val dialog: Dialog = Dialog(context)
    private var dialogButtonOk: TextView? = null
    private var dialogButtonNo: TextView? = null
    private var titleLbl: TextView? = null
    private var subtitleLbl: TextView? = null
    private var separator: View? = null

    init {
        dialog.setContentView(R.layout.ios_dialog)
        if (dialog.window != null)
            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        initViews()
    }

    fun setPositiveListener(listener: IOSDialogListener) {
        dialogButtonOk?.setOnClickListener { listener(this) }
    }

    fun setNegativeListener(listener: IOSDialogListener) {
        dialogButtonNo?.setOnClickListener { listener(this) }
    }

    fun show() {
        if (dialogButtonNo?.text.isNullOrEmpty()) {
            dialogButtonNo?.gone()
            separator?.gone()
        }

        if (dialogButtonOk?.text.isNullOrEmpty()) {
            dialogButtonOk?.gone()
            separator?.gone()
        }

        if (titleLbl?.text.isNullOrEmpty()) titleLbl?.gone()
        if (subtitleLbl?.text.isNullOrEmpty()) subtitleLbl?.gone()

        dialog.show()
    }

    fun dismiss() {
        dialog.dismiss()
    }

    fun setTitle(title: String) {
        titleLbl?.text = title
    }

    fun setSubtitle(subtitle: String) {
        subtitleLbl?.text = subtitle
    }

    fun setPositiveLabel(positive: String) {
        dialogButtonOk?.text = positive
    }

    fun setNegativeLabel(negative: String) {
        dialogButtonNo?.text = negative
    }

    fun setCancelable(isCancelable: Boolean) {
        dialog.setCancelable(isCancelable)
        dialog.setCanceledOnTouchOutside(isCancelable)
    }

    fun setBoldPositiveLabel(bold: Boolean) {
        if (bold)
            dialogButtonOk?.setTypeface(null, Typeface.BOLD)
        else
            dialogButtonOk?.setTypeface(null, Typeface.NORMAL)
    }

    /*

    fun setTipefaces(appleFont: Typeface) {
        titleLbl?.typeface = appleFont
        subtitleLbl?.typeface = appleFont
        dialogButtonOk?.typeface = appleFont
        dialogButtonNo?.typeface = appleFont
    }*/


    private fun initViews() {
        titleLbl = dialog.findViewById(R.id.title)
        subtitleLbl = dialog.findViewById(R.id.subtitle)
        dialogButtonOk = dialog.findViewById(R.id.dialogButtonOK)
        dialogButtonNo = dialog.findViewById(R.id.dialogButtonNO)
        separator = dialog.findViewById(R.id.separator)
    }
}

typealias IOSDialogListener = (dialog: IOSDialog) -> Unit
