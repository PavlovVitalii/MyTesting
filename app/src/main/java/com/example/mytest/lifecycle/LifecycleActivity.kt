package com.example.mytest.lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mytest.R

class LifecycleActivity : AppCompatActivity() {

    private var number: Int = 0
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var newActivityButton: Button
    private val KEY = "key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.d(LIFECYCLE, "onCreate $savedInstanceState")

        button = findViewById(R.id.button_lifecycle)
        textView = findViewById(R.id.textView)
        newActivityButton = findViewById(R.id.button_new_activity)

        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(KEY)
        }

        textView.text = number.toString()

        button.setOnClickListener {
            incrementNumber()
            textView.text = number.toString()
        }

        newActivityButton.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(LIFECYCLE, "onSave")
        outState.putInt(KEY, number)

    }

    private fun incrementNumber() {
        number++
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LIFECYCLE,"onRestart")
    }

    companion object{
        const val LIFECYCLE = "LifecycleTag"
    }
}