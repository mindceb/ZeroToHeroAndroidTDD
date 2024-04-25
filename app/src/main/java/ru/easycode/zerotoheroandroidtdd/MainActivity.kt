package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: LinearLayout

    private lateinit var titleTextView: TextView

    private lateinit var removeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        titleTextView = findViewById(R.id.titleTextView)
        removeButton = findViewById(R.id.removeButton)
        removeButton.setOnClickListener {
            rootLayout.removeView(titleTextView)
            removeButton.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putBoolean(REMOVED_VIEW_KEY, rootLayout.childCount == 1)
        outState.putBoolean(REMOVE_BUTTON_ENABLED_KEY, removeButton.isEnabled)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (!savedInstanceState.getBoolean(REMOVED_VIEW_KEY)) {
            rootLayout.removeView(titleTextView)
        }
        removeButton.isEnabled = savedInstanceState.getBoolean(REMOVE_BUTTON_ENABLED_KEY)
    }

    private companion object {
        private const val REMOVED_VIEW_KEY = "REMOVED_VIEW_KEY"
        private const val REMOVE_BUTTON_ENABLED_KEY = "REMOVE_BUTTON_ENABLED_KEY"
    }
}