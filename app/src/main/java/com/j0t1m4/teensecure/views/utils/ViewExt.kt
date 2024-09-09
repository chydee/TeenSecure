package com.j0t1m4.teensecure.views.utils

import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.text.Spannable
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.toSpannable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs


fun EditText.takeText(): String {
    return this.text.toString().trim()
}

fun View.setBlockingOnClickListener(delayInMills: Long = 200L, action: () -> Unit) {
    var clicked = false
    var prevClickMills = 0L
    setOnClickListener {
        val now = System.currentTimeMillis()
        if (clicked && abs(now - prevClickMills) > delayInMills) {
            clicked = false
        }
        if (!clicked) {
            action.invoke()

            prevClickMills = System.currentTimeMillis()
            clicked = true
        }
    }
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.showIf(condition: Boolean) {
    if (condition) visible() else gone()
}

val View.isVisible: Boolean get() = visibility == View.VISIBLE

fun ImageView.setImageDrawableWithAnimation(drawable: Drawable, duration: Int = 300) {
    val currentDrawable = getDrawable()
    if (currentDrawable == null) {
        setImageDrawable(drawable)
        return
    }

    val transitionDrawable = TransitionDrawable(
        arrayOf(
            currentDrawable,
            drawable
        )
    )
    setImageDrawable(transitionDrawable)
    transitionDrawable.startTransition(duration)
}

fun View.clickWithDebounce(debounceTime: Long = 1000L, lifecycle: Lifecycle, action: () -> Unit) {
    this.setOnClickListener {
        this@clickWithDebounce.isEnabled = false
        action()
        lifecycle.coroutineScope.launch {
            delay(debounceTime)
            this@clickWithDebounce.isEnabled = true
        }
    }
}

fun TextView.setClickableText(startIndex: Int, endIndex: Int, color: Int? = null, onClick: () -> Unit) {
    val span = text.toSpannable().apply {
        setSpan(object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                color?.let { ds.color = it }
                ds.isUnderlineText = false
            }

            override fun onClick(p0: View) {
                onClick.invoke()
            }

        }, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    text = span
    if (movementMethod != LinkMovementMethod.getInstance()) {
        movementMethod = LinkMovementMethod.getInstance()
    }
}