package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView

    private lateinit var rootLayout: LinearLayout

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        titleTextView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)
        button.setOnClickListener {
            rootLayout.removeView(titleTextView)
            button.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removedView = rootLayout.childCount == 1
        outState.putBoolean(VISIBILITY_KEY, removedView)
        outState.putBoolean(ENABLED_KEY, button.isEnabled)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean(VISIBILITY_KEY)) {
            rootLayout.removeView(titleTextView)
        }
        button.isEnabled = savedInstanceState.getBoolean(ENABLED_KEY)
    }

    companion object {
        private const val VISIBILITY_KEY = "VISIBILITY_KEY"
        private const val ENABLED_KEY = "ENABLED_KEY"
    }
}