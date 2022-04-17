package com.example.mytest.lifecycle

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mytest.R


class NewActivity : AppCompatActivity() {
    val LifecycleTag = "LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        Log.d(LifecycleActivity.LIFECYCLE, "createNewActivity")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LifecycleActivity.LIFECYCLE, "startNewActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LifecycleActivity.LIFECYCLE, "resumeNewActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LifecycleActivity.LIFECYCLE, "pauseNewActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LifecycleActivity.LIFECYCLE, "stopNewActivity")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(LifecycleActivity.LIFECYCLE, "saveNewActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LifecycleActivity.LIFECYCLE, "destroyNewActivity")
    }
}
