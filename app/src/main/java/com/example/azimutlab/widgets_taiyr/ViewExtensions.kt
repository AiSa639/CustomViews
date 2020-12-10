package com.example.azimutlab.widgets_taiyr

import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View

fun View.dpToPixel(dp: Float): Float =
    dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)

fun View.dpToPixel(dp: Int): Int =
    dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT).toInt()

fun View.dpToPixelInt(dp: Float): Int =
    (dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()

fun View.pixelToDp(px: Float): Float =
    px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)

fun View.spToPx(sp: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics()).toInt()
}