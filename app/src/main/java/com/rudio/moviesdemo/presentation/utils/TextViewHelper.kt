package com.rudio.moviesdemo.presentation.utils

import android.annotation.SuppressLint
import android.text.method.ScrollingMovementMethod
import android.view.MotionEvent
import android.widget.TextView

class TextViewHelper {

    companion object {

        @SuppressLint("ClickableViewAccessibility")
        fun enableScroll(textView: TextView) {
            textView.movementMethod = ScrollingMovementMethod()
            textView.setOnTouchListener{ view, event ->
                val requestDisallow = when(event?.action) {
                    MotionEvent.ACTION_UP -> false
                    else -> shouldScroll(
                        view as TextView
                    )
                }
                view.parent.requestDisallowInterceptTouchEvent(requestDisallow)
                return@setOnTouchListener false
            }
        }

        @SuppressLint("ClickableViewAccessibility")
        fun disableScroll(textView: TextView) {
            textView.movementMethod = null
            textView.setOnTouchListener{ _, _ ->
                return@setOnTouchListener false
            }
        }

        private fun shouldScroll(textView: TextView): Boolean {
            return (textView.lineHeight * textView.lineCount) > textView.height
        }
    }
}