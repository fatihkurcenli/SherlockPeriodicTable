package com.autumnsun.sherlockperiodictable.util

import android.view.View


fun getGoneView(position: Int): Boolean {
    return when (position) {
        1 -> true
        2 -> true
        3 -> true
        4 -> true
        5 -> true
        6 -> true
        7 -> true
        8 -> true
        else -> false
    }
}

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.remove(){
    this.visibility = View.GONE
}