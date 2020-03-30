package com.methdogg.lodosmovieapp.extension

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

inline fun <reified T : Fragment> FragmentManager.findFragment(tag: String? = null): T? {
    val fragment = this.findFragmentByTag(tag ?: T::class.java.simpleName)
    return fragment as? T
}

inline fun <reified T : DialogFragment> FragmentManager.showDialog(dialog: T, tag: String? = null) {
    dialog.show(this, tag ?: T::class.java.simpleName)
}
