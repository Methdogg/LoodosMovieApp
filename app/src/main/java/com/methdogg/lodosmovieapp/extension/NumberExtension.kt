package com.methdogg.lodosmovieapp.extension

import android.content.res.Resources
import android.util.TypedValue

val Number.px: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()