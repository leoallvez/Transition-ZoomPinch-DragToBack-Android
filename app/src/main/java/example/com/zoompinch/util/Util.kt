package example.com.zoompinch.util

import android.content.Context

object Util {

    fun pxToDp(context: Context, px: Float): Int {
        val density = context.getResources().getDisplayMetrics().density
        return Math.round(px / density)
    }
}