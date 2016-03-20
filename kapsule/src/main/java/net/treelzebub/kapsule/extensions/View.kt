package net.treelzebub.kapsule.extensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver

/**
 * Created by Tre Murillo on 3/19/16
 */

val View.inflater: LayoutInflater get() = LayoutInflater.from(this.context)

fun ViewGroup.inflate(@LayoutRes resId: Int, root: ViewGroup = this, attachToRoot: Boolean = false): View {
    return inflater.inflate(resId, root, attachToRoot)
}

fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setInvisible() {
    visibility = View.INVISIBLE
}

fun View.setGone() {
    visibility = View.GONE
}

fun View.setVisibleGone(pred: Boolean) {
    if (pred) {
        visibility = View.VISIBLE
    } else {
        visibility = View.GONE
    }
}

fun View.setVisibleInvisible(pred: Boolean) {
    if (pred) {
        visibility = View.VISIBLE
    } else {
        visibility = View.INVISIBLE
    }
}

fun View.onNextLayout(fn: () -> Unit) {
    viewTreeObserver?.addOnGlobalLayoutListener(SingleLayoutListener(this, fn))
}

private class SingleLayoutListener(private val view: View, private val fn: () -> Unit) :
        ViewTreeObserver.OnGlobalLayoutListener {
    override fun onGlobalLayout() {
        view.viewTreeObserver?.removeOnGlobalLayoutListener(this)
        fn()
    }
}