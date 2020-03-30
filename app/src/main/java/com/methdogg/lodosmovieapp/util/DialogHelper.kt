package com.methdogg.lodosmovieapp.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.methdogg.lodosmovieapp.extension.findFragment
import com.methdogg.lodosmovieapp.extension.showDialog
import com.methdogg.lodosmovieapp.ui.dialog.ProgressDialog

class DialogHelper(
    private val activity: AppCompatActivity,
    private val fragmentManager: FragmentManager
) {

    fun showLoadingDialog() {
        val progressDialog = fragmentManager.findFragment()
            ?: ProgressDialog()
        fragmentManager.showDialog(progressDialog)
    }

    fun dismissLoadingDialog() {
        fragmentManager.findFragment<ProgressDialog>()?.dismissAllowingStateLoss()
    }

}