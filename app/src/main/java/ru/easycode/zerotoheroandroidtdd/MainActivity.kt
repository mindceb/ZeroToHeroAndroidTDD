package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView

    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        titleTextView = findViewById(R.id.titleTextView)
        val button = findViewById<Button>(R.id.removeButton)
        button.setOnClickListener {
            rootLayout.removeView(titleTextView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removedView = rootLayout.childCount == 1
        outState.putBoolean(VISIBILITY_KEY, removedView)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean(VISIBILITY_KEY)) {
            rootLayout.removeView(titleTextView)
        }
    }

    companion object {
        private const val VISIBILITY_KEY = "key"
    }
}