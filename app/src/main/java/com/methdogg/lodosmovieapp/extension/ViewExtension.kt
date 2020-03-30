package com.methdogg.lodosmovieapp.extension

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.methdogg.lodosmovieapp.util.SimpleDivider

fun RecyclerView.setDivider(
    @DrawableRes drawableRes: Int? = null,
    @ColorRes colorRes: Int? = null,
    height: Int? = null,
    padding: Int = 0,
    orientation: SimpleDivider.Orientation = SimpleDivider.Orientation.VERTICAL,
    showLastDivider: Boolean = true
) {
    this.addItemDecoration(
        SimpleDivider(
            context = context,
            drawableRes = drawableRes,
            colorRes = colorRes,
            height = height?.px,
            padding = padding,
            orientation = orientation,
            showLastDivider = showLastDivider
        )
    )
}

fun View.setVisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}